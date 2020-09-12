package com.finance.manager.service;


import com.finance.manager.entity.Budget;

public interface BudgetService {
    double getBudgetSum();
    void addBudget(Budget budget);
}
