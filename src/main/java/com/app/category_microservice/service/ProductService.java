package com.app.category_microservice.service;

import com.app.category_microservice.model.Category;
import com.app.category_microservice.model.Product;
import com.app.category_microservice.repository.CategoryRepository;
import com.app.category_microservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    //DEPENDENCY INJECTION:
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //CRUD OPERATIONS: ----------------------------------------------
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product, UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryId + " not found"));
        product.setCategory(category);
        productRepository.save(product);
    }

    public void updateProduct(UUID id, Product updatedProduct) {
        Product currentProduct = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product with id " + id + " not found"));
        currentProduct.setName(updatedProduct.getName());
        currentProduct.setPrice(updatedProduct.getPrice());
        productRepository.save(currentProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

}
