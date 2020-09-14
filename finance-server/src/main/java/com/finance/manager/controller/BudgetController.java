package com.finance.manager.controller;

import com.finance.manager.entity.Budget;
import com.finance.manager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/budget")

public class BudgetController {

    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService){
        this.budgetService = budgetService;
    }

    @GetMapping(value = "/sum", produces = "application/json")
    public ResponseEntity getBudgetSumByMonth(@RequestParam int month, @RequestParam int year){
        return budgetService.getBudgetSumByMonth(month, year);
    }

    @GetMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Budget>> getBudgetByMonth(@RequestParam int month, @RequestParam int year){
        return budgetService.getBudgetByMonth(month, year);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){
        return budgetService.addBudget(budget);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> putBudget(@RequestBody Budget budget){
        return budgetService.putBudget(budget);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> putBudget(@PathVariable int id){
        return budgetService.deleteBudget(id);
    }

}
