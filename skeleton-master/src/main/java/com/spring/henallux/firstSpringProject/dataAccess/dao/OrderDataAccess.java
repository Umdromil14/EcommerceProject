package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Order;
import com.spring.henallux.firstSpringProject.model.TransactionDetail;

import java.util.ArrayList;

public interface OrderDataAccess {

    void insertOrder(Order order, String code, ArrayList<TransactionDetail> transactionDetail);
}
