package com.finance.manager.controller;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;
import com.finance.manager.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/api/accounttransaction")
public class AccountTransactionController {

    private AccountTransactionService accountTransactionService;

    @Autowired
    AccountTransactionController(AccountTransactionService accountTransactionService){
        this.accountTransactionService = accountTransactionService;
    }

    @GetMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<AccountTransaction>> getAllAccountTransactionByAccount(@RequestBody Account account) {
        List<AccountTransaction> accountTransactionList = accountTransactionService.getTransactionsByAccount(account);
        return ResponseEntity.ok().body(accountTransactionList);
    }

    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccountTransaction> setAccountTransaction(@RequestBody AccountTransaction accountTransaction){
        AccountTransaction accountTransaction1 = accountTransactionService.setAccountTransaction(accountTransaction);
        URI uri = URI.create("/accounttransaction/" + accountTransaction1.getId());
        return ResponseEntity.created(uri).body(accountTransaction1);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccountTransaction> deleteAccountTransaction(@RequestBody AccountTransaction accountTransaction){
        accountTransactionService.deleteAccountTransaction(accountTransaction);
        return ResponseEntity.ok().body(accountTransaction);
    }
}
