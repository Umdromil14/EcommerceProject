package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.repository.TransactionDetailRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailDAO implements TransactionDetailDataAccess{

    private TransactionDetailRepository transactionDetailRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public TransactionDetailDAO(TransactionDetailRepository transactionDetailRepository, ProviderConverter providerConverter){
        this.transactionDetailRepository = transactionDetailRepository;
        this.providerConverter = providerConverter;
    }
    @Override
    public void insertTransaction(TransactionDetail transactionDetail) {
        transactionDetailRepository.save(providerConverter.transactionDetailModelToTransactionDetailEntity(transactionDetail));
    }
}
