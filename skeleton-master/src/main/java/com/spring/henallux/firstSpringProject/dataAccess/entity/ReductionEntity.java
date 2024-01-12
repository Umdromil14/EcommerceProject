package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="REDUCTION")
public class ReductionEntity {

    @EmbeddedId
    ReductionId id;

    public ReductionEntity(){
        this.id = new ReductionId();
    }

    public Integer getOrderId() {
        return id.getOrderId();
    }

    public String getVoucherCode(){
        return id.getVoucherCode();
    }

    public void setOrderId(Integer orderId) {
        this.id.setOrderId(orderId);
    }

    public void setVoucherCode(String voucherCode){
        this.id.setVoucherCode(voucherCode);
    }
}

@Embeddable
class ReductionId implements Serializable {
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "vouchercode")
    private String voucherCode;

    public ReductionId(){}
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
