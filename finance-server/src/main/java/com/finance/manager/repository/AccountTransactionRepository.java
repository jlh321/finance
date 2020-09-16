package com.finance.manager.repository;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.AccountTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountTransactionRepository extends MongoRepository<AccountTransaction, String> {
    List<AccountTransaction> getAccountTransactionByAccountIs(Account account);
    List<AccountTransaction> getAccountTransactionByMonthIsAndYearIs(int month, int year);
}
