/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.controller;

import com.jefferdev.gestionCuentas.model.Accounts;
import com.jefferdev.gestionCuentas.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeffer-dev
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<Accounts> createUser(@Valid @RequestBody Accounts request) {
        Accounts createdAccount = accountService.createAccount(request.getUserId(), request.getType());
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{accountNumber}")
    public Accounts getByAccountNumber(@PathVariable String accountNumber) {
        return accountService.findByAccount(accountNumber)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado la cuenta con número: " + accountNumber));
    }

}
