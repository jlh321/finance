package com.finance.manager.repository;

import com.finance.manager.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    List<Expense> getExpenseByDayIsAndMonthIsAndYearIs(int day, int month, int year);

    List<Expense> getExpenseByMonthIsAndYearIs(int month, int year);
}

