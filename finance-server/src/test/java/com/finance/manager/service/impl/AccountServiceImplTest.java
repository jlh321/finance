package com.finance.manager.service.impl;

import com.finance.manager.entity.Account;
import com.finance.manager.repository.AccountRepository;
import com.finance.manager.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class AccountServiceImplTest {

    private AccountRepository accountRepository;
    private AccountService accountServiceTest;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountServiceTest = new AccountServiceImpl(accountRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("1","Water"));
        accountList.add(new Account("2","Gas"));
        doReturn(accountList).when(accountRepository).findAll();
        List<Account> result = accountServiceTest.getAllAccounts();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result,accountList);
    }

    @Test
    void setAccount() {
        Account account = new Account("1","Water");
        doReturn(account).when(accountRepository).save(ArgumentMatchers.any(Account.class));
        Account result = accountServiceTest.setAccount(account);
        Assertions.assertNotNull(result);
    }

    @Test
    void deleteAccount() {
        Account account = new Account("1","Water");
        Account result = accountServiceTest.deleteAccount(account);
        verify(accountRepository).delete(account);
    }
}