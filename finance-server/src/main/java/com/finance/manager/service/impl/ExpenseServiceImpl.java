package com.finance.manager.service.impl;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Expense;
import com.finance.manager.repository.ExpenseRepository;
import com.finance.manager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ResponseEntity<List<Expense>> getExpenseByMonth(int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByMonthIsAndYearIs(month, year);
        if(null == expenseList || expenseList.size() ==0 ){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(expenseList);
        }
    }


    @Override
    public ResponseEntity<List<Expense>> getExpenseByDay(int day, int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByDayIsAndMonthIsAndYearIs(day, month, year);
        if(null == expenseList || expenseList.size() ==0 ){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(expenseList);
        }
    }

    @Override
    public ResponseEntity getExpenseSumByMonth(int month, int year) {
        List<Expense> expenseList = expenseRepository.getExpenseByMonthIsAndYearIs(month, year);
        if(null == expenseList || expenseList.size() ==0 ){
            return ResponseEntity.notFound().build();
        }else{
            int sum = 0;
            for(Expense expense : expenseList){
                sum += expense.getAmount();
            }
            return ResponseEntity.ok().body(sum);
        }
    }

    @Override
    public ResponseEntity<Expense> addExpense(Expense expense) {
        expenseRepository.save(expense);
        URI uri = URI.create("/expense" + expense.getId());
        return ResponseEntity.created(uri).body(expense);
    }

    @Override
    public ResponseEntity<Expense> putExpense(Expense expense) {
        if(expenseRepository.existsById(expense.getId())){
            expenseRepository.save(expense);
            return ResponseEntity.ok().body(expense);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Expense> deleteExpense(int id) {
        if(expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
