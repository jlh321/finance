package com.finance.manager.service;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    ResponseEntity<List<Account>> getAllAccounts();
    ResponseEntity<Account> setAccount(Account account);
    ResponseEntity<Account> deleteAccount(int id);
}
