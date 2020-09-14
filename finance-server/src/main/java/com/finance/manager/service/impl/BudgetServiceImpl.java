package com.finance.manager.service.impl;

import com.finance.manager.entity.Budget;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;

    @Autowired
    BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }


    @Override
    public ResponseEntity getBudgetSumByMonth(int month, int year) {
        List<Budget> budgetList = budgetRepository.getBudgetByMonthIsAndYearIs(month, year);
        if(null == budgetList || budgetList.size() ==0 ){
            return ResponseEntity.notFound().build();
        }else {
            int sum = 0;
            for(Budget budget : budgetList){
                sum += budget.getAmount();
            }
            return ResponseEntity.ok().body(sum);
        }
    }

    @Override
    public ResponseEntity<List<Budget>> getBudgetByMonth(int month, int year) {
        List<Budget> budgetList = budgetRepository.getBudgetByMonthIsAndYearIs(month, year);
        if(null == budgetList || budgetList.size() ==0 ){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(budgetList);
        }
    }

    @Override
    public ResponseEntity deleteBudget(int id) {
        if(!budgetRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            System.out.println("Deleting item id " + id);
            budgetRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @Override
    public ResponseEntity<Budget> addBudget(Budget budget){
        budgetRepository.save(budget);
        URI uri = URI.create("/budget/" + budget.getId());
        return ResponseEntity.created(uri).body(budget);
    }

    @Override
    public ResponseEntity<Budget> putBudget(Budget budget) {
        if(budgetRepository.existsById(budget.getId())){
            budgetRepository.save(budget);
            return ResponseEntity.ok().body(budget);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
