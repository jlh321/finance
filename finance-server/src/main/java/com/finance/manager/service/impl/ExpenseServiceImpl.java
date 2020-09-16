package com.finance.manager.service.impl;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Expense;
import com.finance.manager.repository.ExpenseRepository;
import com.finance.manager.service.ExpenseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getExpenseByMonth(int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByMonthIsAndYearIs(month, year);
        return expenseList;
    }


    @Override
    public List<Expense> getExpenseByDay(int day, int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByDayIsAndMonthIsAndYearIs(day, month, year);
        return expenseList;
    }

    @Override
    public double getExpenseSumByMonth(int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByMonthIsAndYearIs(month, year);
        if(expenseList == null || expenseList.size() == 0){
            return 0;
        }else {
            int sum = 0;
            for(Expense expense : expenseList){
                sum += expense.getAmount();
            }
            return sum;
        }
    }

    @Override
    public Expense addExpense(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public Expense putExpense(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public boolean existsById(String id){
        return expenseRepository.existsById(id);
    }


    @Override
    public Expense deleteExpense(Expense expense) {
        Expense expenseResponse = expense;
        expenseRepository.delete(expense);
        return expenseResponse;
    }
}