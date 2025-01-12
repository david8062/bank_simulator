/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.services;

import com.jefferdev.gestionCuentas.dto.TransferRequestDTO;
import com.jefferdev.gestionCuentas.dto.TransferResponseDTO;
import com.jefferdev.gestionCuentas.enums.StateTransactionEnum;
import com.jefferdev.gestionCuentas.enums.TransactionTypeEnum;
import com.jefferdev.gestionCuentas.model.Accounts;
import com.jefferdev.gestionCuentas.model.Transaction;
import com.jefferdev.gestionCuentas.model.TransactionState;
import com.jefferdev.gestionCuentas.model.TransactionType;
import com.jefferdev.gestionCuentas.repository.AccountRepository;
import com.jefferdev.gestionCuentas.repository.TransactionRepository;
import com.jefferdev.gestionCuentas.repository.TransactionStateRepository;
import com.jefferdev.gestionCuentas.repository.TransactionTypeRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeffer-dev
 */
@Service
public class TransactionService {

    // Repositorios
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private TransactionStateRepository transactionStateRepository;

    @Transactional
    public TransferResponseDTO transfer(TransferRequestDTO transferRequest) {

        TransferResponseDTO response = new TransferResponseDTO();
       
        Accounts sourceAccount = accountRepository.findByAccountNumber(transferRequest.getAccount())
                .orElseThrow(() -> new RuntimeException("Cuenta de origen no encontrada"));

        
        Accounts destinationAccount = accountRepository.findByAccountNumber(transferRequest.getDestinationAccount())
                .orElseThrow(() -> new RuntimeException("No se encuentra la cuenta de destino"));

       
        TransactionState state = transactionStateRepository.findByType(
                StateTransactionEnum.valueOf(transferRequest.getTransactionState()))
                .orElseThrow(() -> new RuntimeException("Estado no encontrado: " + transferRequest.getTransactionState()));

        
        TransactionType typeTransaction = transactionTypeRepository.findByType(
                TransactionTypeEnum.valueOf(transferRequest.getTransactionType()))
                .orElseThrow(() -> new RuntimeException("Tipo de transacción no encontrado: " + transferRequest.getTransactionType()));
        
        System.out.println("idAcount recibido: " + transferRequest.getIdAcount());

        
         Accounts user = accountRepository.findById(transferRequest.getIdAcount())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + transferRequest.getIdAcount()));
        
        

        // Validar saldo suficiente
        if (sourceAccount.getBalance().compareTo(transferRequest.getAmount()) < 0) {
            response.setTransactionId(null);
            response.setStatus("FAILED");
            response.setMessage("Saldo insuficiente");
            return response;
        }

        // Realizar la transferencia
        BigDecimal transferAmount = transferRequest.getAmount();
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transferAmount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(transferAmount));

        // Guardar cuentas
        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

        // Crear transacción
        Transaction transaction = new Transaction();      
        transaction.setAccount(user);
        transaction.setBank(transferRequest.getBank());
        transaction.setBalance(transferAmount);
        transaction.setDestinationAccount(destinationAccount.getAccountNumber());
        transaction.setDescription(transferRequest.getNote());
        transaction.setStateTransaction(state);
        transaction.setTransactionType(typeTransaction);    
        transaction.setDescription(transferRequest.getDescription());

        // Guardar transacción
        transactionRepository.save(transaction);

        // Respuesta exitosa
        response.setTransactionId(transaction.getId().toString());
        response.setStatus("SUCCESS");
        response.setMessage("Transferencia completada con éxito");

        return response;
    }
}
