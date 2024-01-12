package com.spring.henallux.firstSpringProject.model;

import java.util.Date;

public class Order {

    private String username;
    
    private Date date;
    
    private Boolean isPayed;
    
    public Order(String username, Date date, Boolean isPayed){
        this.username = username;
        this.date = date;
        this.isPayed = isPayed;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }
}
