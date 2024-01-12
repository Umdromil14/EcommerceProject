package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.VoucherDataAccess;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class VoucherServices {

    private final VoucherDataAccess voucherDAO;

    @Autowired
    public VoucherServices(VoucherDataAccess voucherDAO){
        this.voucherDAO = voucherDAO;
    }

    public Voucher findByCode(String code){
        return voucherDAO.findByCode(code);
    }
    public BigDecimal calculateTotalPriceByCode(String code, HashMap<Product, Integer> purchases){
        Voucher selectedVoucher = findByCode(code);
        if (selectedVoucher!=null){
            Date today = new Date();
            boolean isVoucherValid = false;
            if (selectedVoucher.getStartDate() != null && selectedVoucher.getEndDate() != null){
                if (today.after(selectedVoucher.getStartDate()) && today.before(selectedVoucher.getEndDate())){
                    isVoucherValid = true;
                }
            } else{
                isVoucherValid = true;
            }
            if (isVoucherValid) {
                boolean hasMinOneProduct = false;
                BigDecimal totalPayment = BigDecimal.ZERO;
                for (Map.Entry<Product, Integer> purchase: purchases.entrySet()) {
                    if (purchase.getKey().getCategory().equals(selectedVoucher.getCodeCategory())) {
                        BigDecimal addingValue = (purchase.getKey().getPrice()).multiply(new BigDecimal(purchase.getValue())).multiply((new BigDecimal(1).subtract(selectedVoucher.getPercentage())));
                        totalPayment = totalPayment.add(addingValue);
                        hasMinOneProduct = true;
                    }
                    else{
                        BigDecimal addingValue = (purchase.getKey().getPrice()).multiply(new BigDecimal(purchase.getValue()));
                        totalPayment = totalPayment.add(addingValue);
                    }
                }
                if(hasMinOneProduct){
                    return totalPayment.setScale(2, RoundingMode.CEILING);
                }
            }
        }
        return new BigDecimal(-1);
    }
}