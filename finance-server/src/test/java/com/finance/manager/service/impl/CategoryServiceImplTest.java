package com.finance.manager.service.impl;

import com.finance.manager.entity.Category;
import com.finance.manager.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        for(Category category: categoryList){
            System.out.println(category);
        }
    }

    @Test
    void setCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void existsById() {
    }
}