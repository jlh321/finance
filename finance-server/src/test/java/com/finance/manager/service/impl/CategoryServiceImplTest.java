package com.finance.manager.service.impl;

import com.finance.manager.entity.Category;
import com.finance.manager.repository.BudgetRepository;
import com.finance.manager.repository.CategoryRepository;
import com.finance.manager.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CategoryServiceImplTest {
    private CategoryRepository categoryRepository;
    private CategoryService test;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        test = new CategoryServiceImpl(categoryRepository);

    }


    @Test
    void getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        doReturn(categoryList).when(categoryRepository).findAll();
        List<Category> result = test.getAllCategories();
        assertNotNull(result);

    }

    @Test
    void setCategory() {
        Category category = new Category();
        doReturn(category).when(categoryRepository).save(any(Category.class));
        Category result = test.setCategory(category);
        assertNotNull(result);
    }

    @Test
    void deleteCategory() {
//        Category category = new Category("1111","2222");
//        doNothing().when(categoryRepository).deleteById(anyString());
//
//        doReturn(category).when(categoryRepository).findById(anyString());
//        Category result = test.deleteCategory(category.getId());
//        assertNotNull(result);

    }

    @Test
    void existsById() {
        Category category = new Category("1111","2222");
        doReturn(Boolean.TRUE).when(categoryRepository).existsById(anyString());
        boolean result = test.existsById("1111");
        assertNotNull(result);
    }
}