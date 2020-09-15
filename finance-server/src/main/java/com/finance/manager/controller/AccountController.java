//package com.finance.manager.controller;
//
//import com.finance.manager.entity.Account;
//import com.finance.manager.entity.Category;
//import com.finance.manager.service.AccountService;
//import com.finance.manager.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/account")
//public class AccountController {
//
//    private AccountService accountService;
//
//    @Autowired
//    AccountController(AccountService accountService){
//        this.accountService = accountService;
//    }
//
//    @GetMapping (produces = "application/json", consumes = "application/json")
//    public ResponseEntity<List<Account>> getAllCategories(){
//        return accountService.getAllAccounts();
//    }
//
//    @PostMapping (produces = "application/json", consumes = "application/json")
//    public ResponseEntity<Account> setAccount(@RequestBody Account account){
//        return accountService.setAccount(account);
//    }
//
//    @DeleteMapping (value = "/{id}", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<Account> deleteAccount(@PathVariable int id){
//        return accountService.deleteAccount(id);
//    }
//}
