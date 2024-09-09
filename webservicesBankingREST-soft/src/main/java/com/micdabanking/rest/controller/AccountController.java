package com.micdabanking.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.micdabanking.rest.entity.Account;
import com.micdabanking.rest.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	
    @Autowired
    private AccountRepository accRepo;

    @GetMapping
    public Iterable<Account> findAll() {
        return accRepo.findAll();
    }

    @GetMapping("/account/{accountId}")
    public List<Account> findByName(@PathVariable String accountId) {
        return accRepo.findByName(accountId);
    }

    

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return accRepo.save(account);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        accRepo.findById(id);
        accRepo.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Account updateDrink(@RequestBody Account account, @PathVariable Integer id) {
        accRepo.findById(id);
        return accRepo.save(account);
    }

}