package com.spring.henallux.firstSpringProject.dataAccess.dao;


import com.spring.henallux.firstSpringProject.dataAccess.entity.VoucherEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.VoucherRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherDAO implements VoucherDataAccess {

    private final VoucherRepository voucherRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public VoucherDAO(VoucherRepository voucherRepository, ProviderConverter providerConverter){
        this.voucherRepository = voucherRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Voucher findByCode(String code) {
        VoucherEntity voucherEntity = voucherRepository.findByCode(code);
        if (voucherEntity == null){
            return null;
        }
        return providerConverter.voucherEntityToVoucherModel(voucherEntity);
    }
}
