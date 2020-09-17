package com.finance.manager.service.impl;

import com.finance.manager.controller.BudgetController;
import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Category;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.service.BudgetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class BudgetServiceImplTest {
    private BudgetRepository budgetRepository;
    private BudgetService test;

    @BeforeEach
    void setUp() {
        budgetRepository = mock(BudgetRepository.class);
        test = new BudgetServiceImpl(budgetRepository);

    }



    @Test
    void getBudgetSumByMonth() {
//        Double budgetDouble = 10.0;
        List<Budget> list = new ArrayList<>();
        list.add(new Budget(12D, new Category("asd", "sd"), 10, 202));
        doReturn(list).when(budgetRepository).getBudgetByMonthIsAndYearIs(anyInt(), anyInt());
        Double result = test.getBudgetSumByMonth(10, 2020);
        assertNotNull(result);
    }

    @Test
    void getBudgetByMonth() {
        List<Budget> list = new ArrayList<>();
        list.add(new Budget(12D, new Category("asd", "sd"), 10, 202));
        doReturn(list).when(budgetRepository).getBudgetByMonthIsAndYearIs(anyInt(), anyInt());
        List<Budget> result = test.getBudgetByMonth(10, 2020);
        assertNotNull(result);
//
    }
    //
    @Test
    void deleteBudget() {
        Budget budget = new Budget(12D, new Category("asd", "sd"), 10, 202);
        doNothing().when(budgetRepository).delete(any(Budget.class));
        Budget result = test.deleteBudget(budget);
        assertNotNull(result);
    }

    @Test
    void addBudget() {
        Budget budget = new Budget(12D, new Category("asd", "sd"), 10, 202);
        doReturn(budget).when(budgetRepository).save(any(Budget.class));
        Budget result = (Budget) test.addBudget(budget);
        assertNotNull(result);
    }

    @Test
    void putBudget() {
        Budget budget = new Budget(12D, new Category("asd", "sd"), 10, 202);
        doReturn(budget).when(budgetRepository).save(any(Budget.class));
        Budget result = (Budget) test.putBudget(budget);
        assertNotNull(result);

    }

    @Test
    void existsById() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        budget.setId("12");
        Optional<Budget> option = Optional.of(budget);

        doReturn(option).when(budgetRepository).findById(anyString());
        Boolean result = test.existsById("12");
        assertNotNull(result);

    }
//    @Test
//    void existsById_false() {
//        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
//        budget.setId("12");
//
//        Optional<Budget> option = Optional.ofNullable(budget);
//        option.orElse(null);
//        option = option.filter(item -> item.getId().equals("13") );
//
//        doReturn(option).when(budgetRepository).findById(anyString());
//        Boolean result = test.existsById("12");
//        assertNotNull(result);
//
//    }



}