package com.app.category_microservice.controller;

import com.app.category_microservice.model.Product;
import com.app.category_microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public void addProduct(@RequestBody Product product, @RequestParam UUID categoryId) {
        productService.addProduct(product, categoryId);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/decrementStock/{id}")
    public void decrementStock(@PathVariable UUID id, @RequestParam int quantity) {
        productService.decrementStock(id, quantity);
    }



}
