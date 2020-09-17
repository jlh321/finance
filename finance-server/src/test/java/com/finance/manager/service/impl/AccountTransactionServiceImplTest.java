package com.finance.manager.service.impl;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;
import com.finance.manager.repository.AccountTransactionRepository;
import com.finance.manager.service.AccountService;
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
import static org.mockito.Mockito.*;

class AccountTransactionServiceImplTest {

    private AccountTransactionRepository accountTransactionRepository;
    private AccountTransactionService accountTransactionService;

    @BeforeEach
    void setUp() {
        accountTransactionRepository = mock(AccountTransactionRepository.class);
        accountTransactionService = new AccountTransactionServiceImpl(accountTransactionRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        doReturn(accountTransaction1).when(accountTransactionRepository).save(any(AccountTransaction.class));
        AccountTransaction result = accountTransactionService.setAccountTransaction(accountTransaction1);
        assertEquals(accountTransaction1,result);
    }

    @Test
    void putAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        doReturn(accountTransaction1).when(accountTransactionRepository).save(any(AccountTransaction.class));
        AccountTransaction result = accountTransactionService.putAccountTransaction(accountTransaction1);
        assertEquals(accountTransaction1,result);
    }

    @Test
    void deleteAccountTransaction() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(232,2020,12,11,"good",account1,true);
        AccountTransaction result = accountTransactionService.deleteAccountTransaction(accountTransaction1);
        verify(accountTransactionRepository).delete(accountTransaction1);
    }

    @Test
    void getTransactionsByAccount() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(123,213,2020,9,"good",account1,true);
        AccountTransaction accountTransaction2 = new AccountTransaction(133,123,2020,9,"good",account1,true);
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        accountTransactionList.add(accountTransaction1);
        accountTransactionList.add(accountTransaction2);
        doReturn(accountTransactionList).when(accountTransactionRepository).getAccountTransactionByAccountIs(account1);
        List<AccountTransaction> result = accountTransactionService.getTransactionsByAccount(account1);
        assertEquals(accountTransactionList,result);
    }

    @Test
    void getAccountTransactionByMonth() {
        Account account1 = new Account("1","Yom");
        Account account2 = new Account("2","TOM");
        AccountTransaction accountTransaction1 = new AccountTransaction(123,2020,12,9,"good",account1,true);
        AccountTransaction accountTransaction2 = new AccountTransaction(133,2020,12,9,"good",account1,true);
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        accountTransactionList.add(accountTransaction1);
        accountTransactionList.add(accountTransaction2);
        doReturn(accountTransactionList).when(accountTransactionRepository).getAccountTransactionByMonthIsAndYearIs(anyInt(),anyInt());
        List<AccountTransaction> result = accountTransactionService.getAccountTransactionByMonth(12,2020);
        assertEquals(accountTransactionList,result);
    }
}