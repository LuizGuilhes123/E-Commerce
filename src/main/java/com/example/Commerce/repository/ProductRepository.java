package com.example.Commerce.repository;

import com.example.Commerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Integer> {

    @Query(value = "SELECT p FROM Produto p WHERE p.titulo LIKE %?1%")
    List<ProductEntity> findByTitle(String title);
}
