package com.spring.henallux.firstSpringProject.model;

import java.math.BigDecimal;
import java.util.Date;

public class Voucher {

    private String code;
    private BigDecimal percentage;
    private String reason;
    private Date startDate;
    private Date endDate;
    private String codeCategory;


    public Voucher(){

    }

    public Voucher(String code, String reason, BigDecimal percentage, java.sql.Date startDate, java.sql.Date endDate, String codeCategory){
        this.code = code;
        this.reason = reason;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.codeCategory = codeCategory;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getCodeCategory() {
        return codeCategory;
    }

    public String getReason() {
        return reason;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public BigDecimal getPercentage(){
        return percentage;
    }

    public void setPercentage(BigDecimal percentage){
        this.percentage = percentage;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    public void setEndDate(Date endDate) {
        if (endDate != null){
            this.endDate = endDate;
        }
    }

    public void setReason(String reason) {
        if (reason != null){
            this.reason = reason;
        }
    }

    public void setStartDate(Date startDate) {
        if (startDate != null){
            this.startDate = startDate;
        }
    }
}
