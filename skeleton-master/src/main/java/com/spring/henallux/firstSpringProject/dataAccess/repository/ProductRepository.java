package com.spring.henallux.firstSpringProject.dataAccess.repository;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ArrayList<ProductEntity> findProductsByCategory(String category);
    ProductEntity findProductByID(Integer id);
}
