package com.finance.manager.repository;


import com.finance.manager.component.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BudgetRepository extends MongoRepository<Budget,Long> {
//    List<Budget> findBudget();
}
