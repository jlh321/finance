package com.finance.manager.service;

import com.finance.manager.entity.Expense;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseService {
    List<Expense> getExpenseByMonth(int month, int year);
    List<Expense> getExpenseByDay(int day, int month, int year);
    double getExpenseSumByMonth(int month, int year);
    Expense addExpense(Expense expense);
    Expense putExpense(Expense expense);
    Expense deleteExpense(Expense expense);
    boolean existsById(String id);
}
