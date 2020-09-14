package com.finance.manager.controller;

import com.finance.manager.entity.Category;
import com.finance.manager.entity.Expense;
import com.finance.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Category>> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Category> setCategory(@RequestBody Category category){
        return categoryService.setCategory(category);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }
}
