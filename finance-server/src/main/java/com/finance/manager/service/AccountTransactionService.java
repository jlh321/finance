package com.finance.manager.service;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransaction> getTransactionsByAccount(Account account);
    AccountTransaction setAccountTransaction(AccountTransaction accountTransaction);
    AccountTransaction putAccountTransaction(AccountTransaction accountTransaction);
    AccountTransaction deleteAccountTransaction(AccountTransaction accountTransaction);
}
