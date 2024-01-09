package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="PRODUCT")
public class ProductEntity {

    @Id
    @Column (name="ID")
    private Integer ID;

    @Column (name="Name")
    private String name;

    @Column (name="Description")
    private String description;

    @Column (name="actualunitprice")
    private BigDecimal actualUnitPrice;

    @Column (name="codecategory")
    private String category;

    public ProductEntity() {
    }

    public ProductEntity (Integer ID, String name, String description, BigDecimal actualUnitPrice, String category) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.actualUnitPrice = actualUnitPrice;
        this.category = category;
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getId() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getActualUnitPrice() {
        return actualUnitPrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActualUnitPrice(BigDecimal actualUnitPrice) {
        this.actualUnitPrice = actualUnitPrice;
    }
    //endregion
}
