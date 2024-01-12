package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="`ORDER`")
public class OrderEntity {

    //region variables
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ID;

    @Column(name="username")
    private String username;

    @Column(name="date")
    private Date date;

    @Column(name="ispayed")
    private Boolean isPayed;
    //endregion

    public OrderEntity(){}

    //region getters
    public Integer getID() {
        return ID;
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
    //endregion

    //region setters
    public void setID(Integer ID) {
        this.ID = ID;
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
    //endregion
}
