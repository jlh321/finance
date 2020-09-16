package com.finance.manager.service.impl;

import com.finance.manager.entity.Expense;
import com.finance.manager.repository.ExpenseRepository;
import com.finance.manager.service.ExpenseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ExpenseServiceImplTest {
    private ExpenseRepository expenseRepository;
    private ExpenseService test;

    @BeforeEach
    void setUp() {
        expenseRepository = mock(ExpenseRepository.class);
        test = new ExpenseServiceImpl(expenseRepository);
    }


    @Test
    void getExpenseByMonth() {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense());
        doReturn(expenseList).when(expenseRepository).getExpenseByMonthIsAndYearIs(anyInt(),anyInt());
        List<Expense> result = test.getExpenseByMonth(10,2020);
        assertNotNull(result);


    }

    @Test
    void getExpenseByDay() {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense());
        doReturn(expenseList).when(expenseRepository).getExpenseByDayIsAndMonthIsAndYearIs(anyInt(),anyInt(),anyInt());
        List<Expense> result = test.getExpenseByDay(10,10,2020);
        assertNotNull(result);

    }

    @Test
    void getExpenseSumByMonth() {

    }

    @Test
    void addExpense() {
        Expense expense = new Expense();
        doReturn(expense).when(expenseRepository).save(any(Expense.class));
        Expense result = test.addExpense(expense);
        assertNotNull(result);
    }

    @Test
    void putExpense() {
        Expense expense = new Expense();
        doReturn(expense).when(expenseRepository).save(any(Expense.class));
        Expense result = test.putExpense(expense);
        assertNotNull(result);
    }



    @Test
    void deleteExpense() {
        Expense expense = new Expense();
        doNothing().when(expenseRepository).delete(any(Expense.class));
        Expense result = test.deleteExpense(expense);
        assertNotNull(result);

    }



    @Test
    void existsById() {

        doReturn(Boolean.TRUE).when(expenseRepository).existsById(anyString());
        Boolean result =test.existsById("1111");
        assertNotNull(result);


    }
}