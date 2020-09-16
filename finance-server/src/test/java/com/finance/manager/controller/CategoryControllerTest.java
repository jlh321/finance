package com.finance.manager.controller;
import com.finance.manager.ManagerApplication;
import com.finance.manager.entity.Category;
import com.finance.manager.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.*;


//@SpringBootTest(classes = ManagerApplication.class )
class CategoryControllerTest {

    //    @Autowired
    private CategoryController test;
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = mock(CategoryService.class);
        test = new CategoryController(categoryService);
    }

//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        doReturn(categoryList).when(categoryService).getAllCategories();
        ResponseEntity result = test.getAllCategories();
        assertNotNull(result);
    }

    @Test
    void setCategory() {
        Category category = new Category("1","XXXX");
        doReturn(category).when(categoryService).setCategory(any(Category.class));
        ResponseEntity result = test.setCategory(category);
        assertNotNull(result);
    }

    @Test
    void deleteCategory_with_true() {
        Category category= new Category("1","XXXX");
        category.setId("2");
        doReturn(Boolean.TRUE).when(categoryService).existsById("2");
        doReturn(category).when(categoryService).deleteCategory(anyString());
        ResponseEntity result = test.deleteCategory(category.getId());
        assertNotNull(result);
    }

    @Test
    void deleteCategory_with_false() {
        Category category= new Category("1","XXXX");
        category.setId("2");
        doReturn(Boolean.FALSE).when(categoryService).existsById("3");
        doReturn(category).when(categoryService).deleteCategory(anyString());
        ResponseEntity result = test.deleteCategory(category.getId());
        assertNotNull(result);

    }
}