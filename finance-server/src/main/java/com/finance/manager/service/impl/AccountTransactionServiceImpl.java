package com.finance.manager.service.impl;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;
import com.finance.manager.repository.AccountTransactionRepository;
import com.finance.manager.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionServiceImpl(AccountTransactionRepository accountTransactionRepository){
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public AccountTransaction setAccountTransaction(AccountTransaction accountTransaction) {
        AccountTransaction accountTransaction1 = accountTransactionRepository.save(accountTransaction);
        return accountTransaction1;
    }

    @Override
    public AccountTransaction putAccountTransaction(AccountTransaction accountTransaction) {
        AccountTransaction accountTransaction1 = accountTransactionRepository.save(accountTransaction);
        return accountTransaction1;
    }

    @Override
    public AccountTransaction deleteAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionRepository.delete(accountTransaction);
        return accountTransaction;
    }

    @Override
    public List<AccountTransaction> getTransactionsByAccount(Account account) {
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.getAccountTransactionByAccountIs(account);
        return accountTransactionList;
    }

    @Override
    public List<AccountTransaction> getAccountTransactionByMonth(int month, int year){
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.getAccountTransactionByMonthIsAndYearIs(month, year);
        return accountTransactionList;
    }
}
