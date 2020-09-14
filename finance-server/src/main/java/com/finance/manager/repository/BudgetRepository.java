package com.finance.manager.repository;


import com.finance.manager.entity.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface BudgetRepository extends MongoRepository<Budget,Integer> {
    List<Budget> findBudget();
    public Budget findById(int id);
}
