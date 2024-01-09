package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.TransactionDetailDataAccess;
import com.spring.henallux.firstSpringProject.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailServices {

    private TransactionDetailDataAccess transactionDetailDAO;

    @Autowired
    public TransactionDetailServices(TransactionDetailDataAccess transactionDetailDAO){
        this.transactionDetailDAO = transactionDetailDAO;
    }

    public void insertTransactionDetail(TransactionDetail transactionDetail){
        transactionDetailDAO.insertTransaction(transactionDetail);
    }
}
