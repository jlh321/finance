package com.finance.manager.service;

import com.finance.manager.entity.Category;


import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category setCategory(Category category);
    Category deleteCategory(String id);
    boolean existsById(String id);
}
