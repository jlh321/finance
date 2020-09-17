package com.finance.manager.repository;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account getAccountByNameIs(String name);
}
