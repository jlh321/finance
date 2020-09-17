package com.finance.manager.controller;

import com.finance.manager.entity.Account;
import com.finance.manager.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping (produces = "application/json")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accountList = accountService.getAllAccounts();
        return ResponseEntity.ok().body(accountList);
    }

    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<Account> setAccount(@RequestBody Account account){
        Account account1 = accountService.setAccount(account);
        URI uri = URI.create("/account/" + account1.getId());
        return ResponseEntity.created(uri).body(account1);
    }

    @DeleteMapping ( produces = "application/json", consumes = "application/json")
    public ResponseEntity<Account> deleteAccount(@RequestBody Account account){
        accountService.deleteAccount(account);
        return ResponseEntity.ok().body(account);
    }
}
