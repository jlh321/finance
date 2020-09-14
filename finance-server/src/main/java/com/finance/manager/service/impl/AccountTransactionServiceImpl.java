package com.finance.manager.service.impl;

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
    public ResponseEntity<AccountTransaction> setAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionRepository.save(accountTransaction);
        URI uri = URI.create("/accountTransaction/" + accountTransaction.getId());
        return ResponseEntity.created(uri).body(accountTransaction);
    }

    @Override
    public ResponseEntity<AccountTransaction> deleteAccountTransaction(int id) {
        if(accountTransactionRepository.existsById(id)){
            accountTransactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<AccountTransaction>> getTransactionsByAccount(int accountId) {
        List<AccountTransaction> accountTransactions = accountTransactionRepository.getBudgetByAccountIdIs(accountId);
        if(accountTransactions == null || accountTransactions.size() == 0){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(accountTransactions);
        }
    }
}
