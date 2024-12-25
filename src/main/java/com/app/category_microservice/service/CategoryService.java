package com.app.category_microservice.service;

import com.app.category_microservice.model.Category;
import com.app.category_microservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    //DEPENDENCY INJECTION:
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    //CRUD OPERATIONS: ----------------------------------------------
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(UUID id, Category updatedCategory) {
        Category currentCategory = categoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Category with id " + id + " not found"));
        currentCategory.setName(updatedCategory.getName());
        categoryRepository.save(currentCategory);
    }

    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}
