package com.example.Commerce.controller;

import com.example.Commerce.entity.CategoryEntity;
import com.example.Commerce.entity.ProductEntity;
import com.example.Commerce.service.CategoryService;
import com.example.Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping
    private ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @GetMapping
    private ResponseEntity<List<ProductEntity>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<ProductEntity>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/by/{title}")
    private ResponseEntity<List<ProductEntity>> findForTitle(@PathVariable String title){
        return ResponseEntity.ok(productService.findForTitle(title));
    }

    @PostMapping("/category")
    private ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
    }

    @GetMapping("/category/{name}")
    private ResponseEntity<List<CategoryEntity>> findByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @GetMapping("/category")
    private ResponseEntity<List<CategoryEntity>> findAllCategorys(){
        return ResponseEntity.ok(categoryService.findAllCategorys());
    }

}
