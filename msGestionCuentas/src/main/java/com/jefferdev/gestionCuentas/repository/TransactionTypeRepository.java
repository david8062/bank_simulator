/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jefferdev.gestionCuentas.repository;

import com.jefferdev.gestionCuentas.enums.TransactionTypeEnum;
import com.jefferdev.gestionCuentas.model.TransactionType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeffer-dev
 */
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
  public Optional<TransactionType> findByType(TransactionTypeEnum transactionType);
}
