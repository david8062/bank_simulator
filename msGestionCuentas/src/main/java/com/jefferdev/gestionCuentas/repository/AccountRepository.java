/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jefferdev.gestionCuentas.repository;

import com.jefferdev.gestionCuentas.model.Accounts;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeffer-dev
 */
public interface AccountRepository extends JpaRepository <Accounts, Long>{
    public boolean existsByAccountNumber(String account);
    
    public Optional <Accounts> findByAccountNumber (String numberAccount);    
    public Optional <Accounts> findByUserId(String userId);
    
}
