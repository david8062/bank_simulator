/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.model;

import com.jefferdev.gestionCuentas.enums.AccountEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author jeffer-dev
 */
@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @NotBlank(message = "El ID del usuario es obligatorio")
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false)
    private LocalDateTime date_creation = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_account")
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_state_type")
    private AccountStatesType stateType;

    public AccountEnum getType() {
        return type;
    }
    
    @Enumerated(EnumType.STRING)
    private AccountEnum type;   

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    public AccountStatesType getStateType() {
        return stateType;
    }

    public void setStateType(AccountStatesType stateType) {
        this.stateType = stateType;
    }

}
