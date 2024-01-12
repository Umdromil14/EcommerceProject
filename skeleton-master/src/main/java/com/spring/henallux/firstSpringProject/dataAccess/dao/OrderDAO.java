package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ReductionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TransactionDetailRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Order;
import com.spring.henallux.firstSpringProject.model.Reduction;
import com.spring.henallux.firstSpringProject.model.TransactionDetail;
import com.spring.henallux.firstSpringProject.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class OrderDAO implements OrderDataAccess{

    private final OrderRepository orderRepository;
    private final ProviderConverter providerConverter;
    private final TransactionDetailRepository transactionDetailRepository;
    private final ReductionRepository reductionRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter,ReductionRepository reductionRepository ,TransactionDetailRepository transactionDetailRepository){
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
        this.reductionRepository = reductionRepository;
        this.transactionDetailRepository = transactionDetailRepository;
    }

    @Transactional
    @Override
    public void insertOrder(Order order, String code, ArrayList<TransactionDetail> transactions) {
        OrderEntity newOrder = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(newOrder);

        if(code != null){
            reductionRepository.save(providerConverter.reductionModelToReductionEntity(new Reduction(newOrder.getID(), code)));
        }
        for(TransactionDetail transaction : transactions){
            transaction.setOrderId(newOrder.getID());
            transactionDetailRepository.save(providerConverter.transactionDetailModelToTransactionDetailEntity(transaction));
        }
    }
}
