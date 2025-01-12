/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.model;

import com.jefferdev.gestionCuentas.enums.TransactionTypeEnum;
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
@Table (name = "transaction_Type")
public class TransactionType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idTransactionType;
    
    
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    public Long getId() {
        return idTransactionType;
    }

    public void setId(Long id) {
        this.idTransactionType = id;
    }

    public TransactionTypeEnum getType() {
        return type;
    }

    public void setType(TransactionTypeEnum type) {
        this.type = type;
    }
    
    
}
