package com.app.category_microservice.controller;

import com.app.category_microservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.category_microservice.model.Category;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //instead of Category you might want to ResponseEntity
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/update/{id}")
    public void updateCategory(@PathVariable UUID id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
    }

}
















