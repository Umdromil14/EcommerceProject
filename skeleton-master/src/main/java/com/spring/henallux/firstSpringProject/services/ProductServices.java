package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductsDataAccess;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ProductServices {
    private ProductsDataAccess ProductDAO;

    @Autowired
    public ProductServices(ProductsDataAccess ProductDAO){
        this.ProductDAO = ProductDAO;
    }

    public ProductServices(){
    }

    public ArrayList<Product> getAllSellsByCategory(String category){
        return ProductDAO.findProductsByCategory(category);
    }
    public Product getProductById(Integer id){
        return ProductDAO.findProductById(id);
    }

    public HashMap<Product,Integer> addProductToBasket(HashMap<Product,Integer> basket, Product product, Integer quantity){
        if (!basket.isEmpty()){
            for (Product productInBasket : basket.keySet()) {
                if (productInBasket.getID().equals(product.getID())) {
                    quantity += basket.get(productInBasket);
                    product = productInBasket;
                }
            }
        }
        basket.put(product, quantity);
        return basket;
    }

    public Integer getPurchasesCount(HashMap<Product,Integer> purchases){
        int purchasesCount = 0;
        if (purchases != null) {
            for (int quantity : purchases.values()) {
                purchasesCount += quantity;
            }
        }
        return purchasesCount;
    }
}