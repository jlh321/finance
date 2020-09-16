package com.finance.manager.controller;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Expense;
import com.finance.manager.service.BudgetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/budget")

public class BudgetController {

    private BudgetService budgetService;
    @Autowired
    public BudgetController(BudgetService budgetService){
        this.budgetService = budgetService;
    }

    @GetMapping(value = "/sum", produces = "application/json")
    public ResponseEntity getBudgetSumByMonth(@RequestParam int month, @RequestParam int year){
        Double budgetSumByMonth = budgetService.getBudgetSumByMonth(month, year);
        return ResponseEntity.ok().body(budgetSumByMonth);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Budget>> getBudgetByMonth(@RequestParam int month, @RequestParam int year){
        List<Budget> budgetList = budgetService.getBudgetByMonth(month, year);
        if(null == budgetList || budgetList.size() == 0){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(budgetList);
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){
        Budget budgetResponse = budgetService.addBudget(budget);
        URI uri = URI.create("/budget/" + budget.getId());
        return ResponseEntity.created(uri).body(budgetResponse);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> putBudget(@RequestBody Budget budget){
        if (budgetService.existsById(budget.getId())) {
            Budget budgetResponse = budgetService.putBudget(budget);
            return ResponseEntity.ok().body(budgetResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> deleteBudget(@RequestBody Budget budget){
        if (budgetService.existsById(budget.getId())) {
            Budget budgetResponse = budgetService.deleteBudget(budget);
            return ResponseEntity.ok().body(budgetResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

