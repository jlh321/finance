package com.finance.manager.service.impl;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.Category;
import com.finance.manager.repository.AccountRepository;
import com.finance.manager.repository.CategoryRepository;
import com.finance.manager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accountList =  accountRepository.findAll();
        return accountList;
    }

    @Override
    public Account setAccount(Account account) {
        Account account1 = accountRepository.save(account);
        return account1;
    }

    @Override
    public Account deleteAccount(Account account) {
        accountRepository.delete(account);
        return account;
    }
}
