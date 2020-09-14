package com.finance.manager.service;

import com.finance.manager.entity.AccountTransaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountTransactionService {
    ResponseEntity<AccountTransaction> setAccountTransaction(AccountTransaction account);
    ResponseEntity<AccountTransaction> deleteAccountTransaction(int id);
    ResponseEntity<List<AccountTransaction>> getTransactionsByAccount(int accountId);
}
