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
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accountList =  accountRepository.findAll();
        if(accountList == null || accountList.size()==0){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(accountList);
        }
    }

    @Override
    public ResponseEntity<Account> setAccount(Account account) {
        accountRepository.save(account);
        URI uri = URI.create("/account/" + account.getId());
        return ResponseEntity.created(uri).body(account);
    }

    @Override
    public ResponseEntity<Account> deleteAccount(int id) {
        if(!accountRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            System.out.println("Deleting item id " + id);
            accountRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
