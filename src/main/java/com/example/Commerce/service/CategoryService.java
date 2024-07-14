package com.example.Commerce.service;

import com.example.Commerce.entity.CategoryEntity;
import com.example.Commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity createCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }

    public List<CategoryEntity> findAllCategorys(){
        return categoryRepository.findAll();
    }

    public List<CategoryEntity> findByName(String name){
        return categoryRepository.findByName(name);
    }
}
