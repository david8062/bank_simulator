/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.model;

import com.jefferdev.gestionCuentas.enums.StateEnum;
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
@Table(name = "state_types")
public class AccountStatesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStateType;

    @Enumerated(EnumType.STRING)
    private StateEnum stateTypeEnum;

    public long getIdStateType() {
        return idStateType;
    }

    public void setIdStateType(long idStateType) {
        this.idStateType = idStateType;
    }

    public StateEnum getStateEnum() {
        return stateTypeEnum;
    }

    public void setStateEnum(StateEnum stateEnum) {
        this.stateTypeEnum = stateEnum;
    }

}
