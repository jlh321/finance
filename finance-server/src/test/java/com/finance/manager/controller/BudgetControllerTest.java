package com.finance.manager.controller;
import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Category;
import com.finance.manager.service.BudgetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.*;


class BudgetControllerTest {

    private BudgetController test;
    private BudgetService budgetService;

    @BeforeEach
    void setUp() {
        budgetService = mock(BudgetService.class);
        test = new BudgetController(budgetService);
    }

    @Test
    void getBudgetSumByMonth() {
        Double budgetDouble = 10.0;
        doReturn(budgetDouble).when(budgetService).getBudgetSumByMonth(anyInt(), anyInt());
        ResponseEntity result = test.getBudgetSumByMonth(10, 2020);
        assertNotNull(result);
    }

    @Test
    void getBudgetByMonth() {
        List<Budget> budgetList = new ArrayList<>();
        budgetList.add(new Budget(10.D, new Category("11", "test"), 2020, 9));
        doReturn(budgetList).when(budgetService).getBudgetByMonth(anyInt(), anyInt());
        ResponseEntity result = test.getBudgetByMonth(10, 2020);
        assertNotNull(result);
        List<Budget> ll = (List<Budget>) result.getBody();
        assertEquals(1, ll.size());
        System.out.println(ll.get(0).getCategory().getId());
    }

    @Test
    void addBudget() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        doReturn(budget).when(budgetService).addBudget(budget);
        ResponseEntity result = test.addBudget(budget);
        assertNotNull(result);
        Budget ll = (Budget) result.getBody();
        System.out.println(ll.getYear());
    }

    @Test
    void putBudget_with_true() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        budget.setId("12");
        doReturn(Boolean.TRUE).when(budgetService).existsById("12");
        doReturn(budget).when(budgetService).putBudget(any(Budget.class));
        ResponseEntity result = test.putBudget(budget);
        assertNotNull(result);
//        Budget ll = (Budget) result.getBody();
//        System.out.println(ll.getYear());
    }

    @Test
    void putBudget_with_false() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        budget.setId("11");
        doReturn(Boolean.FALSE).when(budgetService).existsById("12");
        doReturn(budget).when(budgetService).putBudget(any(Budget.class));
        ResponseEntity result = test.putBudget(budget);
        assertNotNull(result);
    }

    @Test
    void deleteBudget_with_true() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        budget.setId("12");
        doReturn(Boolean.TRUE).when(budgetService).existsById("12");
        doReturn(budget).when(budgetService).deleteBudget(any(Budget.class));
        ResponseEntity result = test.deleteBudget(budget);
        assertNotNull(result);
    }

    @Test
    void deleteBudget_with_false() {
        Budget budget = new Budget(12.D, new Category("1", "Rent"), 2019, 11);
        budget.setId("11");
        doReturn(Boolean.FALSE).when(budgetService).existsById("12");
        doReturn(budget).when(budgetService).deleteBudget(any(Budget.class));
        ResponseEntity result = test.deleteBudget(budget);
        assertNotNull(result);
    }
}