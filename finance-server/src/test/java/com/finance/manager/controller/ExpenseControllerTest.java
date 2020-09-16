package com.finance.manager.controller;

import com.finance.manager.entity.Category;
import com.finance.manager.entity.Expense;
import com.finance.manager.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


class ExpenseControllerTest {
    private ExpenseController test;
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = mock(ExpenseService.class);
        test = new ExpenseController(expenseService);
    }


    @Test
    void getExpenseByMonth() {
        List<Expense> expenseList = new ArrayList<>();
        doReturn(expenseList).when(expenseService).getExpenseByMonth(anyInt(), anyInt());
        ResponseEntity result = test.getExpenseByMonth(10, 2020);
        assertNotNull(result);

    }

    @Test
    void getExpenseByDay() {
        List<Expense> expenseList = new ArrayList<>();
        doReturn(expenseList).when(expenseService).getExpenseByDay(anyInt(), anyInt(),anyInt());
        ResponseEntity result = test.getExpenseByDay(10,10,2020);
        assertNotNull(result);
    }

    @Test
    void getExpenseSumByMonth() {
        Double expenseSum = new Double(0);
        doReturn(expenseSum).when(expenseService).getExpenseSumByMonth(anyInt(), anyInt());
        ResponseEntity result = test.getExpenseSumByMonth(10,2020);
        assertNotNull(result);

    }

    @Test
    void addExpense() {
        Expense expense = new Expense();
        doReturn(expense).when(expenseService).addExpense(any(Expense.class));
        ResponseEntity result = test.addExpense(expense);
        assertNotNull(result);
    }

    @Test
    void putExpense() {
        Category category = new Category("1","Rent");
        Expense expense = new Expense(12D,category,2020,2,4,"dddd");
        expense.setId("12");
        doReturn(Boolean.TRUE).when(expenseService).existsById("12");
        doReturn(expense).when(expenseService).putExpense(any(Expense.class));
        ResponseEntity result = test.putExpense(expense);
        assertNotNull(result);
        Expense ll = (Expense) result.getBody();
        System.out.println(ll.getDescription());

    }



    @Test
    void deleteExpense_with_true() {
        Expense expense = new Expense();
        expense.setId("12");
        expense.setDescription("test");
        doReturn(Boolean.TRUE).when(expenseService).existsById("12");
        doReturn(expense).when(expenseService).deleteExpense(any(Expense.class));
        ResponseEntity result2 = test.deleteExpense(expense);
        assertNotNull(result2);
        Expense ll = (Expense) result2.getBody();
        System.out.println(ll.getDescription());
    }

    @Test
    void deleteExpense_with_false() {
        Expense expense = new Expense();
        expense.setId("12");
        expense.setDescription("test");
        doReturn(Boolean.FALSE).when(expenseService).existsById("13");
        doReturn(expense).when(expenseService).deleteExpense(any(Expense.class));
        ResponseEntity result2 = test.deleteExpense(expense);
        assertNotNull(result2);
    }
}