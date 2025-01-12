/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jefferdev.gestionCuentas.repository;

import com.jefferdev.gestionCuentas.enums.StateEnum;
import com.jefferdev.gestionCuentas.model.AccountStatesType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeffer-dev
 */
@Repository
public interface StateTypesRepository extends JpaRepository<AccountStatesType, Long> {
    Optional<AccountStatesType> findByStateTypeEnum(StateEnum stateEnum);
}
