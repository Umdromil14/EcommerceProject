package com.spring.henallux.firstSpringProject.model;

public class Reduction {

    private Integer orderId;

    private String voucherCode;

    public Reduction(Integer orderId, String voucherCode){
        setOrderId(orderId);
        setVoucherCode(voucherCode);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
}
