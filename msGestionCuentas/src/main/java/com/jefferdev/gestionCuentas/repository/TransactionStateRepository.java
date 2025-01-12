/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jefferdev.gestionCuentas.repository;


import com.jefferdev.gestionCuentas.enums.StateTransactionEnum;
import com.jefferdev.gestionCuentas.model.TransactionState;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeffer-dev
 */
public interface TransactionStateRepository extends JpaRepository<TransactionState, Long> {

    Optional<TransactionState> findByType(StateTransactionEnum stateTransactionEnum);
}
