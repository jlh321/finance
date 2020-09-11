package com.finance.manager.service.impl;

import com.finance.manager.component.Budget;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;

    @Autowired
    BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public long getBudgetSum() {
        List<Budget> budgetList = budgetRepository.findAll();
        long sum = 0;
        for(Budget budget: budgetList){
            sum += budget.getExpense();
        }
        return sum;
    }
}
