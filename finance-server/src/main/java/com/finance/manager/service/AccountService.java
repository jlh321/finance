package com.finance.manager.service;

import com.finance.manager.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account setAccount(Account account);
    Account deleteAccount(int id);
}
