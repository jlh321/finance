package com.finance.manager.service;


import com.finance.manager.entity.Budget;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BudgetService {
    ResponseEntity<Budget> addBudget(Budget budget);
    ResponseEntity<Budget> putBudget(Budget budget);
    ResponseEntity getBudgetSumByMonth(int month, int year);
    ResponseEntity<List<Budget>> getBudgetByMonth(int month, int year);
    ResponseEntity<Budget> deleteBudget(int id);
}
