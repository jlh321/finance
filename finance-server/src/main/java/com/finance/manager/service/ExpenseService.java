package com.finance.manager.service;

import com.finance.manager.entity.Expense;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseService {
    ResponseEntity<List<Expense>> getExpenseByMonth(int month, int year);
    ResponseEntity<List<Expense>> getExpenseByDay(int day, int month, int year);
    ResponseEntity getExpenseSumByMonth(int month, int year);
    ResponseEntity<Expense> addExpense(Expense expense);
    ResponseEntity<Expense> putExpense(Expense expense);
    ResponseEntity<Expense> deleteExpense(int id);
}
