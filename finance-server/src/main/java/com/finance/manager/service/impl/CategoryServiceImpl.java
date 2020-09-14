package com.finance.manager.service.impl;

import com.finance.manager.entity.Category;
import com.finance.manager.repository.CategoryRepository;
import com.finance.manager.service.CategoryService;
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
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList =  categoryRepository.findAll();
        if(categoryList == null || categoryList.size()==0){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(categoryList);
        }
    }

    @Override
    public ResponseEntity<Category> setCategory(Category category) {
        categoryRepository.save(category);
        URI uri = URI.create("/category/" + category.getId());
        return ResponseEntity.created(uri).body(category);
    }

    @Override
    public ResponseEntity<Category> deleteCategory(int id) {
        if(!categoryRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            System.out.println("Deleting item id " + id);
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
