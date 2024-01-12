package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServices {

    private final OrderDataAccess orderDAO;
    private final VoucherServices voucherServices;

    @Autowired
    public OrderServices(OrderDataAccess orderDAO, VoucherServices voucherServices){
        this.orderDAO = orderDAO;
        this.voucherServices = voucherServices;
    }

    public void insertOrder(Order order, String voucherCode, HashMap<Product,Integer> basket){
        Voucher voucher = null;
        if(voucherCode != null){
            voucher = voucherServices.findByCode(voucherCode);
        }

        ArrayList<TransactionDetail> transactions = new ArrayList<>();

        for(Map.Entry<Product, Integer> purchase: basket.entrySet()){
            Product product = purchase.getKey();
            BigDecimal transactionPrice;
            if(voucher != null && product.getCategory().equals(voucher.getCodeCategory())){
                transactionPrice = product.getPrice().multiply(new BigDecimal(1).subtract(voucher.getPercentage()));
            }
            else {
                transactionPrice = product.getPrice();
            }
            transactionPrice = transactionPrice.setScale(2, RoundingMode.CEILING);
            transactions.add(new TransactionDetail(purchase.getValue(), transactionPrice, product.getID()));
        }
        orderDAO.insertOrder(order, voucherCode, transactions);
    }
}
