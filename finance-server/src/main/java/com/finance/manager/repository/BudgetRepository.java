package com.finance.manager.repository;


import com.finance.manager.entity.Budget;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface BudgetRepository extends MongoRepository<Budget, String> {

    List<Budget> getBudgetByMonthIsAndYearIs(int month, int year);

}
