package com.spring.henallux.firstSpringProject.model;

import java.util.Date;

public class Order {

    private Integer userId;
    
    private Date date;
    
    private Boolean isPayed;
    
    public Order(Integer userId, Date date, Boolean isPayed){
        this.userId = userId;
        this.date = date;
        this.isPayed = isPayed;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }
}
