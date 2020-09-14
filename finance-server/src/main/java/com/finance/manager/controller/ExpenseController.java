package com.finance.manager.controller;

import com.finance.manager.entity.Expense;
import com.finance.manager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")

public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/getbymonth", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Expense>> getExpenseByMonth(@RequestParam int month, @RequestParam int year){
        return expenseService.getExpenseByMonth(month,  year);
    }

    @GetMapping(value = "/getbyday", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Expense>> getExpenseByDay(@RequestParam int day, @RequestParam int month, @RequestParam int year){
        return expenseService.getExpenseByDay(day, month,  year);
    }

    @GetMapping(value = "/all", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Expense>> getExpenseAll(@RequestParam int month, @RequestParam int year){
        return expenseService.getExpenseSumByMonth(month, year);
    }

    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> putExpense(@RequestBody Expense expense){
        return expenseService.putExpense(expense);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> putExpense(@PathVariable int id){
        return expenseService.deleteExpense(id);
    }
}
