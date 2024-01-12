package com.spring.henallux.firstSpringProject.model;

import java.math.BigDecimal;

public class Product {
    private Integer ID;
    private BigDecimal price;
    private String name;
    private String description;
    private String category;

    public Product(Integer ID, BigDecimal price, String name, String description, String category) {
        this.ID = ID;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Product() {
    }

    //region getters and setters
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public Integer getID() {
        return ID;
    }
    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    //endregion
}
