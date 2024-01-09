package com.spring.henallux.firstSpringProject.model;

import java.math.BigDecimal;

public class TransactionDetail {

    private Integer quantity;

    private BigDecimal transactionPrice;

    private Integer productId;

    private Integer orderId;

    public TransactionDetail(Integer quantity, BigDecimal transactionPrice, Integer productId, Integer orderId){
        setQuantity(quantity);
        setTransactionPrice(transactionPrice);
        setProductId(productId);
        setOrderId(orderId);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getTransactionPrice() {
        return transactionPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTransactionPrice(BigDecimal transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
