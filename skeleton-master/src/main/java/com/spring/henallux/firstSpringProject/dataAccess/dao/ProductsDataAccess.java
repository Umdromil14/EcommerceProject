package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Product;

import java.util.ArrayList;

public interface ProductsDataAccess {

    ArrayList<Product> findProductsByCategory(String category);
    Product findProductById(Integer id);
}
