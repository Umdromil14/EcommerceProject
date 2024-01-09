package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {

    private OrderDataAccess orderDAO;

    @Autowired
    public OrderServices(OrderDataAccess orderDAO){
        this.orderDAO = orderDAO;
    }

    public Integer insertOrder(Order order){
        return orderDAO.insertOrder(order);
    }
}
