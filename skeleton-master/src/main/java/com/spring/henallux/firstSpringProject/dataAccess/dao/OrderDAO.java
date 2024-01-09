package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO implements OrderDataAccess{

    private OrderRepository orderRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter){
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Integer insertOrder(Order order) {
        OrderEntity newOrder = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(newOrder);
        return newOrder.getID();
    }
}
