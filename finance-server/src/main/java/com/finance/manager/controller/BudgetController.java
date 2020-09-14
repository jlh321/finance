package com.finance.manager.controller;

import com.finance.manager.entity.Budget;
import com.finance.manager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/budget")

public class BudgetController {

    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService){
        this.budgetService = budgetService;
    }

    @GetMapping(value = "/sum", produces = "application/json")
    public double getBudgetSum(){
        return budgetService.getBudgetSum();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){
        budgetService.addBudget(budget);
        URI uri = URI.create("/budget/" + budget.getId());
        return ResponseEntity.created(uri).body(budget);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Budget> putBudget(@PathVariable int id, @RequestBody Budget budget){
        return budgetService.putBudget(budget);
    }

}
