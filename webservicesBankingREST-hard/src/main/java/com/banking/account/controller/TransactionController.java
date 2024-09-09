package com.banking.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.account.dto.TransactionDto;
import com.banking.account.dto.TransactionResponse;
import com.banking.account.service.TransactionService;

@RestController
@RequestMapping("/account/")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("transction")
    public ResponseEntity<TransactionResponse> getTransctions(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(transactionService.getAllTransaction(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("transction/{id}")
    public ResponseEntity<TransactionDto> TransctionDetail(@PathVariable int id){
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
    }

    @PostMapping("transction")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionDto> createTransction(@RequestBody TransactionDto Transction, @RequestParam int guestId, @RequestParam int roomId){
        return new ResponseEntity<>(transactionService.createTransaction(Transction, guestId, roomId), HttpStatus.CREATED);
    }

    @PutMapping("transction/{id}")
    public ResponseEntity<TransactionDto> updateTransction(@RequestBody TransactionDto transactionDto, @PathVariable("id") int TransctionId){
        TransactionDto response = transactionService.updateTransaction(transactionDto, TransctionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
