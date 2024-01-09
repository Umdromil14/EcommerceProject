package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Voucher;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherDataAccess {
    Voucher findByCode(String code);
}
