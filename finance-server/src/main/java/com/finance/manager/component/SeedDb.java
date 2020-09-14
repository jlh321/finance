package com.finance.manager.component;

import com.finance.manager.entity.Budget;
import com.finance.manager.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    private BudgetRepository budgetRepository;

    @Autowired
    SeedDb(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @PostConstruct
    public void init(){
        budgetRepository.save(new Budget(1,9.7,1,2020,9));
        budgetRepository.save(new Budget(2,10.5,2,2020,9));
        budgetRepository.save(new Budget(3,22.1,2,2020,9));
    }
}
