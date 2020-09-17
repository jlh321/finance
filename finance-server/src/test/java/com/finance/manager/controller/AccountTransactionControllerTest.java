package com.finance.manager.controller;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;
import com.finance.manager.entity.Budget;
import com.finance.manager.service.AccountTransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class AccountTransactionControllerTest {

    private AccountTransactionService accountTransactionService;
    private AccountTransactionController accountTransactionController;

    @BeforeEach
    void setUp() {
        accountTransactionService = mock(AccountTransactionService.class);
        accountTransactionController = new AccountTransactionController(accountTransactionService);
    }


    @Test
    void getAllAccountTransactionByAccount() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(123,213,2020,9,"good",account1,true);
        AccountTransaction accountTransaction2 = new AccountTransaction(133,123,2020,9,"good",account1,true);
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        accountTransactionList.add(accountTransaction1);
        accountTransactionList.add(accountTransaction2);
        doReturn(accountTransactionList).when(accountTransactionService).getTransactionsByAccount(account1);
        ResponseEntity result = accountTransactionController.getAllAccountTransactionByAccount(account1);
        List<AccountTransaction> resultBody = (List<AccountTransaction>) result.getBody();
        assertEquals(accountTransactionList,accountTransactionList);
    }

    @Test
    void getAccountTransactionByMonth() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        AccountTransaction accountTransaction2 = new AccountTransaction(133,2020,12,9,"good",account2,true);
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        accountTransactionList.add(accountTransaction1);
        accountTransactionList.add(accountTransaction2);
        doReturn(accountTransactionList).when(accountTransactionService).getAccountTransactionByMonth(anyInt(),anyInt());
        ResponseEntity result = accountTransactionController.getAccountTransactionByMonth(12,2020);
        List<AccountTransaction> resultBody = (List<AccountTransaction>) result.getBody();
        assertEquals(accountTransactionList,accountTransactionList);
    }

    @Test
    void setAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        doReturn(accountTransaction1).when(accountTransactionService).setAccountTransaction(any(AccountTransaction.class));
        ResponseEntity result = accountTransactionController.setAccountTransaction(accountTransaction1);
        AccountTransaction resultBody = (AccountTransaction) result.getBody();
        assertEquals(accountTransaction1,resultBody);
    }

    @Test
    void putAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        doReturn(accountTransaction1).when(accountTransactionService).putAccountTransaction(any(AccountTransaction.class));
        ResponseEntity result = accountTransactionController.putAccountTransaction(accountTransaction1);
        AccountTransaction resultBody = (AccountTransaction) result.getBody();
        assertEquals(accountTransaction1,resultBody);
    }

    @Test
    void deleteAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        doReturn(accountTransaction1).when(accountTransactionService).putAccountTransaction(any(AccountTransaction.class));
        ResponseEntity result = accountTransactionController.putAccountTransaction(accountTransaction1);
        AccountTransaction resultBody = (AccountTransaction) result.getBody();
        assertEquals(accountTransaction1,resultBody);
    }
}