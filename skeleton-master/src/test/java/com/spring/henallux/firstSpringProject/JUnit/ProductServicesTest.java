package com.spring.henallux.firstSpringProject.JUnit;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductsDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.services.ProductServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProductServicesTest {

    private ProductServices productServices;

    @Mock
    private ProductRepository productRepository;

    private ProductsDAO productsDAO;


    @BeforeEach
    void setUp() {
        productServices = new ProductServices();
        productsDAO = new ProductsDAO(productRepository, new ProviderConverter());
    }

    @Test
    void getAllSellsByCategory() {
        ArrayList<ProductEntity> mockedProductEntities = new ArrayList<>();
        mockedProductEntities.add(new ProductEntity(8,"Chocolate waffle","Chocolate waffle",new BigDecimal("3.00"),"Snacks"));
        mockedProductEntities.add(new ProductEntity(9,"Madeleine","chocolate filled madeleine",new BigDecimal("4.99"),"Snacks"));
        mockedProductEntities.add(new ProductEntity(10,"M&Ms","M&Ms",new BigDecimal("4.99"),"Snacks"));
        when(productRepository.findProductsByCategory("Snacks")).thenReturn(mockedProductEntities);
        ArrayList<Product> resultsProducts = new ArrayList<>();
        resultsProducts.add(new Product(8,new BigDecimal("3.00"),"Chocolate waffle","Chocolate waffle","Snacks"));
        resultsProducts.add(new Product(9,new BigDecimal("4.99"),"Madeleine","chocolate filled madeleine","Snacks"));
        resultsProducts.add(new Product(10,new BigDecimal("4.99"),"M&Ms","M&Ms","Snacks"));
        ArrayList<Product> products = productsDAO.findProductsByCategory("Snacks");
        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getID(), resultsProducts.get(i).getID());
            assertEquals(products.get(i).getPrice(), resultsProducts.get(i).getPrice());
            assertEquals(products.get(i).getCategory(), resultsProducts.get(i).getCategory());
            assertEquals(products.get(i).getDescription(), resultsProducts.get(i).getDescription());
            assertEquals(products.get(i).getName(), resultsProducts.get(i).getName());
        }

    }

    @Test
    void getProductById() {
        ProductEntity mockedProductEntity = new ProductEntity(19, "Henallux logo","Henallux logo",new BigDecimal("299.99"),"Construction");
        when(productRepository.findProductByID(19)).thenReturn(mockedProductEntity);
        Product product = new Product(19, new BigDecimal("299.99"), "Henallux logo", "Henallux logo", "Construction");
        Product resultProduct = productsDAO.findProductById(19);
        assertEquals(product.getID(), resultProduct.getID());
        assertEquals(product.getPrice(), resultProduct.getPrice());
        assertEquals(product.getCategory(), resultProduct.getCategory());
        assertEquals(product.getDescription(), resultProduct.getDescription());
        assertEquals(product.getName(), resultProduct.getName());
    }

    @Test
    void getPurchasesCount() {
        HashMap<Product,Integer> purchases = new HashMap<>();
        purchases.put(new Product(1,new BigDecimal("1.5"),"spa reine","still water","Beverages"),2);
        purchases.put(new Product(2,new BigDecimal("2.5"),"coca-cola","soda","Beverages"),3);
        purchases.put(new Product(3,new BigDecimal("3.5"),"fanta","soda","Beverages"),4);
        assertEquals(9,productServices.getPurchasesCount(purchases),0.01);
    }

    @Test
    void getPurchasesCountNull() {
        HashMap<Product,Integer> purchases = null;
        assertEquals(0,productServices.getPurchasesCount(purchases),0.01);
    }
}