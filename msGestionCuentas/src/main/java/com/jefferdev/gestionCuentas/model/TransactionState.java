/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.model;

import com.jefferdev.gestionCuentas.enums.StateTransactionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author jeffer-dev
 */
@Entity
@Table(name = "state_transaction")
public class TransactionState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStateTransaction;

    @Enumerated(EnumType.STRING)
    private StateTransactionEnum type;

    public Long getIdStateTransaction() {
        return idStateTransaction;
    }

    public void setIdStateTransaction(Long idStateTransaction) {
        this.idStateTransaction = idStateTransaction;
    }

    public StateTransactionEnum getType() {
        return type;
    }

    public void setType(StateTransactionEnum type) {
        this.type = type;
    }

}
