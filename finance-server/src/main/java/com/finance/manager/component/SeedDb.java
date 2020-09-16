package com.finance.manager.component;

import com.finance.manager.entity.*;
import com.finance.manager.repository.*;
import org.bson.types.ObjectId;
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
        //init predefined categories
        categoryRepository.save(new Category("Utilities"));
        categoryRepository.save(new Category("Travel"));
        categoryRepository.save(new Category("Groceries"));
        categoryRepository.save(new Category("Drinks"));
        categoryRepository.save(new Category("Rent"));
        categoryRepository.save(new Category("Cell Phone"));
        categoryRepository.save(new Category("Car Payments"));
        categoryRepository.save(new Category("Fun Money"));
        budgetRepository.save(new Budget(1.7,categoryRepository.getCategoryByNameIs("Utilities"),2020,9));
        budgetRepository.save(new Budget(10.5,categoryRepository.getCategoryByNameIs("Travel"),2020,9));
        budgetRepository.save(new Budget(22.1,categoryRepository.getCategoryByNameIs("Drinks"),2020,9));
        expenseRepository.save(new Expense(22.1,categoryRepository.getCategoryByNameIs("Car Payments"),2020,9,22,"dea"));
        expenseRepository.save(new Expense(22.1,categoryRepository.getCategoryByNameIs("Car Payments"),2020,9,21,"qqq"));
        expenseRepository.save(new Expense(22.1,categoryRepository.getCategoryByNameIs("Car Payments"),2020,9,20,"eee"));

        //        accountRepository.save(new Account(1,"Water"));
//        accountRepository.save(new Account(2,"Gas"));
//        accountTransactionRepository.save(new AccountTransaction(112,21,2020,9,14,"good",1));
    }
}
