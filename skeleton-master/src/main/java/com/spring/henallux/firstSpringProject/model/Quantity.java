package com.spring.henallux.firstSpringProject.model;

public class Quantity {

    private Integer quantity;

    public Quantity(Integer quantity){
        this.quantity = quantity;
    }

    public Quantity(){}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
