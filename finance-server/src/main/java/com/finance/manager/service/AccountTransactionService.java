package com.finance.manager.service;

import com.finance.manager.entity.AccountTransaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountTransactionService {
    AccountTransaction setAccountTransaction(AccountTransaction account);
    AccountTransaction deleteAccountTransaction(int id);
    List<AccountTransaction> getTransactionsByAccount(int accountId);
}
