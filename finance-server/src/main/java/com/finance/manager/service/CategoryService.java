package com.finance.manager.service;

import com.finance.manager.entity.Category;
import com.finance.manager.entity.Expense;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<List<Category>> getAllCategories();
    ResponseEntity<Category> setCategory(Category category);
    ResponseEntity<Category> deleteCategory(int id);
}
