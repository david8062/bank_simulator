/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefferdev.gestionCuentas.controller;

import com.jefferdev.gestionCuentas.dto.TransferRequestDTO;
import com.jefferdev.gestionCuentas.dto.TransferResponseDTO;
import com.jefferdev.gestionCuentas.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeffer-dev
 */
@RestController
@RequestMapping("/api/transactions")
public class TransferController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransferResponseDTO> transfer(@RequestBody TransferRequestDTO transferRequest) {
        try {

            TransferResponseDTO response = transactionService.transfer(transferRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {

            TransferResponseDTO errorResponse = new TransferResponseDTO();
            errorResponse.setStatus("FAILED");
            errorResponse.setMessage(e.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working");
    }
}
