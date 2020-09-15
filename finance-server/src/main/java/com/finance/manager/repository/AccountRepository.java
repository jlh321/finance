package com.finance.manager.repository;

import com.finance.manager.entity.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, ObjectId> {
}
