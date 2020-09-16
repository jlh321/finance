package com.finance.manager.service;

import com.finance.manager.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account setAccount(Account account);
    Account deleteAccount(Account account);
}
