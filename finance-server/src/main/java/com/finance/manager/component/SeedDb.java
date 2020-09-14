package com.finance.manager.component;

import com.finance.manager.entity.Account;
import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Category;
import com.finance.manager.entity.Expense;
import com.finance.manager.repository.AccountRepository;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.repository.CategoryRepository;
import com.finance.manager.repository.ExpenseRepository;
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

//    @Autowired
//    SeedDb(BudgetRepository budgetRepository, ExpenseRepository expenseRepository, CategoryRepository categoryRepository,
//           AccountRepository accountRepository){
//        this.budgetRepository = budgetRepository;
//        this.expenseRepository = expenseRepository;
//        this.categoryRepository = categoryRepository;
//        this.accountRepository = accountRepository;
//    }


    @PostConstruct
    public void init(){
        budgetRepository.save(new Budget(1,9.7,1,2020,9));
        budgetRepository.save(new Budget(2,10.5,2,2020,9));
        budgetRepository.save(new Budget(3,22.1,2,2020,9));
        expenseRepository.save(new Expense(3,22.1,2,2020,9,22,"dea"));
        categoryRepository.save(new Category(1,"Water"));
        accountRepository.save(new Account(1,"Water"));

    }
}
