package com.finance.manager.component;

import com.finance.manager.entity.*;
import com.finance.manager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @PostConstruct
    public void init(){
        budgetRepository.save(new Budget(1,9.7,1,2020,9));
        budgetRepository.save(new Budget(2,10.5,2,2020,9));
        budgetRepository.save(new Budget(3,22.1,2,2020,9));
        expenseRepository.save(new Expense(3,22.1,2,2020,9,22,"dea"));
        categoryRepository.save(new Category(1,"Water"));
        accountRepository.save(new Account(1,"Water"));
        accountRepository.save(new Account(2,"Gas"));
        accountTransactionRepository.save(new AccountTransaction(112,21,2020,9,14,"good",1));
    }
}
