package com.finance.manager.repository;

import com.finance.manager.entity.AccountTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountTransactionRepository extends MongoRepository<AccountTransaction, Integer> {
    List<AccountTransaction> getBudgetByAccountIdIs(int accountId);
}
