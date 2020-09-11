package com.finance.manager.component;

import org.springframework.data.annotation.Id;

public class Budget {
    @Id
    private long budgetId = 1;

    private long expense;

    public Budget(){

    }

    public Budget(long budgetId, long sum){
        this.budgetId = budgetId;
        this.expense = sum;
    }


    public long getExpense() {
        return expense;
    }

    public void setExpense(long expense) {
        this.expense = expense;
    }

    public long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(long budgetId) {
        this.budgetId = budgetId;
    }
}