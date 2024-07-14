package com.example.Commerce.service;

import com.example.Commerce.entity.ProductEntity;
import com.example.Commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Integer id){
        return productRepository.findById(id);
    }

    public List<ProductEntity> findForTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }
}
