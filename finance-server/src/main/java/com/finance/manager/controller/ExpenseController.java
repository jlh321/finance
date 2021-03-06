package com.finance.manager.controller;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Expense;
import com.finance.manager.service.ExpenseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/expense")

public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/getbymonth", produces = "application/json")
    public ResponseEntity<List<Expense>> getExpenseByMonth(@RequestParam int month, @RequestParam int year){
        List<Expense> expenseList = expenseService.getExpenseByMonth(month, year);
        return ResponseEntity.ok().body(expenseList);
    }

    @GetMapping(value = "/getbyday", produces = "application/json")
    public ResponseEntity<List<Expense>> getExpenseByDay(@RequestParam int day, @RequestParam int month, @RequestParam int year){
        List<Expense> expenseList = expenseService.getExpenseByDay(day, month, year);
        return ResponseEntity.ok().body(expenseList);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<Double> getExpenseSumByMonth(@RequestParam int month, @RequestParam int year){
        List<Expense> expenseList = expenseService.getExpenseByMonth(month, year);
        if(null == expenseList || expenseList.size() == 0){
            return ResponseEntity.ok().body(0.0);
        }else {
            Double expenseSumByMonth = expenseService.getExpenseSumByMonth(month, year);
            return ResponseEntity.ok().body(expenseSumByMonth);
        }
    }

    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        Expense expenseResponse = expenseService.addExpense(expense);
        URI uri = URI.create("/expense/" + expense.getId());
        return ResponseEntity.created(uri).body(expenseResponse);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> putExpense(@RequestBody Expense expense){
        if (expenseService.existsById(expense.getId())) {
            Expense expenseResponse = expenseService.putExpense(expense);
            return ResponseEntity.ok().body(expenseResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Expense> deleteExpense(@RequestBody Expense expense){
        if (expenseService.existsById(expense.getId())) {
            Expense expenseResponse = expenseService.deleteExpense(expense);
            return ResponseEntity.ok().body(expenseResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
