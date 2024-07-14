package com.example.Commerce.repository;

import com.example.Commerce.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository <CategoryEntity, Integer> {

    List<CategoryEntity> findByName(String name);
}
