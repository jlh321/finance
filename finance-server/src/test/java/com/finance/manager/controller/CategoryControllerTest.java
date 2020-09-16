package com.finance.manager.controller;

import com.finance.manager.ManagerApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = ManagerApplication.class )
class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        System.out.println("start----");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCategories() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void deleteCategory() {
    }
}