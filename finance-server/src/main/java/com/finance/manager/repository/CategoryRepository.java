package com.finance.manager.repository;

import com.finance.manager.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category getCategoryByNameIs(String name);
}
