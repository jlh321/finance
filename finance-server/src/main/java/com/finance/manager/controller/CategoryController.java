package com.finance.manager.controller;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Category;
import com.finance.manager.entity.Expense;
import com.finance.manager.service.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        if(categoryList == null || categoryList.size() ==0){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(categoryList);
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Category> setCategory(@RequestBody Category category){
        Category categoryResponse = categoryService.setCategory(category);
        URI uri = URI.create("/category/" + category.getId());
        return ResponseEntity.created(uri).body(categoryResponse);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Category> deleteCategory(@PathVariable String id){
        if (categoryService.existsById(id)) {
            Category category = categoryService.deleteCategory(id);
            return ResponseEntity.ok().body(category);
        }else {
            return ResponseEntity.notFound().build();
        }
    };
}

