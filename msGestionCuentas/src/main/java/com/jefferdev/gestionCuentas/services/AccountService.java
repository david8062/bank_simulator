/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.services;

import com.jefferdev.gestionCuentas.enums.AccountEnum;
import com.jefferdev.gestionCuentas.model.AccountType;
import com.jefferdev.gestionCuentas.model.Accounts;
import com.jefferdev.gestionCuentas.enums.StateEnum;
import com.jefferdev.gestionCuentas.model.AccountStatesType;
import com.jefferdev.gestionCuentas.repository.AccountRepository;
import com.jefferdev.gestionCuentas.repository.AccountTypeRepository;
import com.jefferdev.gestionCuentas.repository.StateTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author jeffer-dev
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private StateTypesRepository stateTypesRepository;

    public Accounts createAccount(String userId, AccountEnum accountTypeEnum) {

        AccountType accountType = accountTypeRepository.findByType(accountTypeEnum)
                .orElseThrow(() -> new RuntimeException("Tipo de cuenta no encontrado"));

        String accountNumber = createAccountNumber();

        Accounts account = new Accounts();
        account.setAccountNumber(accountNumber);
        account.setUserId(userId);
        account.setBalance(BigDecimal.ZERO);
        account.setDate_creation(LocalDateTime.now());
        account.setAccountType(accountType);
        AccountStatesType activeState = stateTypesRepository.findByStateTypeEnum(StateEnum.activa)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        account.setStateType(activeState);

        return accountRepository.save(account);
    }

    public Optional<Accounts> findByAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    private String createAccountNumber() {
        Random random = new Random();
        String accountNumber;
        do {
            accountNumber = String.format("%08d", random.nextInt(100000000)); // 8 dígitos
        } while (accountRepository.existsByAccountNumber(accountNumber));  // Asegurarse de que no exista
        return accountNumber;
    }
}
