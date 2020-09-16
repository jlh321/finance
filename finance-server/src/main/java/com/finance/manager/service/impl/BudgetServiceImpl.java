package com.finance.manager.service.impl;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Expense;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.service.BudgetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;

    @Autowired
    BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }


    @Override
    public double getBudgetSumByMonth(int month, int year) {
        List<Budget> budgetList = budgetRepository.getBudgetByMonthIsAndYearIs(month, year);
        if (budgetList == null || budgetList.size() == 0) {
            return 0;
        } else {
            int sum = 0;
            for (Budget budget : budgetList) {
                sum += budget.getAmount();
            }
            return sum;
        }
    }

    @Override
    public List<Budget> getBudgetByMonth(int month, int year) {
        List<Budget> budgetList = budgetRepository.getBudgetByMonthIsAndYearIs(month, year);
        return budgetList;
    }

    @Override
    public Budget deleteBudget(Budget budget) {
        Budget budgetResponse = budget;
        budgetRepository.delete(budget);
        return budget;
    }


    @Override
    public Budget addBudget(Budget budget) {
        Budget budget1 = budgetRepository.save(budget);
        return budget1;
    }

    @Override
    public boolean existsById(String id){
        Budget budget = budgetRepository.findById(id).get();
        if(budget == null){
            return false;
        }
        return true;
    }

    @Override
    public Budget putBudget(Budget budget) {
        Budget budget1 = budgetRepository.save(budget);
        return budget1;
    }
}