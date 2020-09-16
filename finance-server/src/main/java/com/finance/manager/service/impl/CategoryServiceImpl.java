package com.finance.manager.service.impl;

import com.finance.manager.entity.Budget;
import com.finance.manager.entity.Category;
import com.finance.manager.repository.CategoryRepository;
import com.finance.manager.service.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList =  categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public Category setCategory(Category category) {

        Category category1 = categoryRepository.save(category);
        return category1;
    }

    @Override
    public Category deleteCategory(String id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.deleteById(id);
        return category;
    }

    @Override
    public boolean existsById(String id){
        return categoryRepository.existsById(id);
    }
}
