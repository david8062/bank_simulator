/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 *
 * @author jeffer-dev
 */
public class TransferRequestDTO {
    @NotNull
    @Size(min = 8, max = 20, message = "El número de cuenta de origen debe tener entre minimo 8 caracteres")
    private String account;
    @NotNull
    @Size (min = 8, message = "La cuente de destino debe tener minimo 8 caracteres")
    private String destinationAccount;
    @NotNull
    @Positive (message = "El valor no puede ser negativo")
    private BigDecimal amount;
    @NotNull
    @Size (min = 1, message = "Debe elegir el banco de destino")
    private String bank;
    @NotNull(message = "Debe elegir el tipo de transaccion")
    private String transactionType;
    @NotNull
    private String transactionState;
    @NotNull (message = "el id de la cuenta no puede ir vacio")
    private Long idAcount;
    private String description;

    public String getDescription() {
        return description;
    }

    public Long getIdAcount() {
        return idAcount;
    }

    public void setIdAcount(Long idAcount) {
        this.idAcount = idAcount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    private String note;
    
    
    
}
