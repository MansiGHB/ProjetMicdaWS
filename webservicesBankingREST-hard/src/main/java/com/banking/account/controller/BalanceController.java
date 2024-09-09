package com.banking.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.BalanceTransactionResponse;
import com.banking.account.dto.BalanceResponse;
import com.banking.account.model.Balance;
import com.banking.account.service.BalanceService;

@RestController
@RequestMapping("/account/")
public class BalanceController {
    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("balance")
    public ResponseEntity<BalanceResponse> getBalances(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(balanceService.getAllBalance(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("balance/{id}")
    public ResponseEntity<BalanceDto> BalanceDetail(@PathVariable int id){
        return new ResponseEntity<>(balanceService.getBalanceById(id), HttpStatus.OK);
    }

    @PostMapping("balance")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BalanceDto> createBalance(@RequestBody Balance balance){
        return new ResponseEntity<>(balanceService.createBalance(balance), HttpStatus.CREATED);
    }

    @PutMapping("balance/{id}")
    public ResponseEntity<BalanceDto> updateBalance(@RequestBody BalanceDto balanceDto, @PathVariable("id") int BalanceId){
        BalanceDto response = balanceService.updateBalance(balanceDto, BalanceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("balance/{id}")
    public ResponseEntity<String> deleteBalance(@PathVariable("id") int BalanceId){
        balanceService.deleteBalanceById(BalanceId);
        return new ResponseEntity<>("Balance deleted", HttpStatus.OK);
    }

}
