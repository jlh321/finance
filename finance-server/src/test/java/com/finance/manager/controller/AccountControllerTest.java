package com.finance.manager.controller;

import com.finance.manager.entity.Account;
import com.finance.manager.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountControllerTest {

    private AccountService accountService;
    private AccountController accountControllerTest;

    @BeforeEach
    void setUp() {
        accountService = mock(AccountService.class);
        accountControllerTest = new AccountController(accountService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAccounts() {
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account("1","Water"));
        accountList.add(new Account("2","Gas"));
        doReturn(accountList).when(accountService).getAllAccounts();
        ResponseEntity responseEntity = accountControllerTest.getAllAccounts();
        verify(accountService).getAllAccounts();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(2,((List<Account>)responseEntity.getBody()).size());
    }

    @Test
    void setAccount() {
        Account account1 = new Account("1","Water");
        doReturn(account1).when(accountService).setAccount(any(Account.class));
        ResponseEntity responseEntity = accountControllerTest.setAccount(account1);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }

    @Test
    void deleteAccount() {
        Account account1 = new Account("1","Water");
        ResponseEntity responseEntity = accountControllerTest.deleteAccount(account1);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
}