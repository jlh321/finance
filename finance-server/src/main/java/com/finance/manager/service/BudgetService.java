package com.finance.manager.service;


import com.finance.manager.entity.Budget;
import org.springframework.http.ResponseEntity;

public interface BudgetService {
    double getBudgetSum();
    void addBudget(Budget budget);
    ResponseEntity<Budget> putBudget(Budget budget);
}
