/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author jeffer-dev
 */
@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO; 
    
    @Column(nullable = false)
    private String bank;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String destinationAccount; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_transaction_type", nullable = false)
    private TransactionType transactionType; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account", nullable = false)
    private Accounts account; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_state_transaction", nullable = false)
    private TransactionState stateTransaction; 

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime dateTransaction = LocalDateTime.now();
    
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public TransactionState getStateTransaction() {
        return stateTransaction;
    }

    public void setStateTransaction(TransactionState stateTransaction) {
        this.stateTransaction = stateTransaction;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}

