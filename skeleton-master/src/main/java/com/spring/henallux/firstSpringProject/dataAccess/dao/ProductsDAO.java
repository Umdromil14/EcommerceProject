package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductsDAO implements ProductsDataAccess{

    private final ProductRepository productsRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public ProductsDAO(ProductRepository productsRepository, ProviderConverter providerConverter){
        this.productsRepository = productsRepository;
        this.providerConverter = providerConverter;
    }
    @Override
    public Product findProductById(Integer id) {
        ProductEntity productEntity = productsRepository.findProductByID(id);
        return providerConverter.productEntityToProductModel(productEntity);
    }

    @Override
    public ArrayList<Product> findProductsByCategory(String category) {
        ArrayList<ProductEntity> productEntities = productsRepository.findProductsByCategory(category);
        ArrayList<Product> products = new ArrayList<>();
        for(ProductEntity productEntity : productEntities){
            Product product = providerConverter.productEntityToProductModel(productEntity);
            products.add(product);
        }
        return products;
    }
}
