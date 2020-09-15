//package com.finance.manager.controller;
//
//import com.finance.manager.entity.AccountTransaction;
//import com.finance.manager.entity.Category;
//import com.finance.manager.service.AccountTransactionService;
//import com.finance.manager.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping ("/api/accounttransaction")
//public class AccountTransactionController {
//
//    private AccountTransactionService accountTransactionService;
//
//    @Autowired
//    AccountTransactionController(AccountTransactionService accountTransactionService){
//        this.accountTransactionService = accountTransactionService;
//    }
//
//    @GetMapping (produces = "application/json", consumes = "application/json")
//    public ResponseEntity<List<AccountTransaction>> getAllAccountTransactionByAccount(@RequestParam int accountId) {
//        return accountTransactionService.getTransactionsByAccount(accountId);
//    }
//
//    @PostMapping (produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccountTransaction> setAccountTransaction(@RequestBody AccountTransaction accountTransaction){
//        return accountTransactionService.setAccountTransaction(accountTransaction);
//    }
//
//    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccountTransaction> deleteAccountTransaction(@PathVariable int id){
//        return accountTransactionService.deleteAccountTransaction(id);
//    }
//}
