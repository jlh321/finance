package com.finance.manager.service;


import com.finance.manager.entity.Budget;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BudgetService {
    Budget addBudget(Budget budget);
    Budget putBudget(Budget budget);
    double getBudgetSumByMonth(int month, int year);
    List<Budget> getBudgetByMonth(int month, int year);
    Budget deleteBudget(Budget budget);
    boolean existsById(String id);
}
