package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="TRANSACTION_DETAILS")
public class TransactionDetailEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="transactionprice")
    private Double transactionPrice;

    @Column(name="productid")
    private Integer productId;

    @Column(name="orderid")
    private Integer orderId;

    public TransactionDetailEntity(){}

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
