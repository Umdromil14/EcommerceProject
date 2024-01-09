package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="VOUCHER")
public class VoucherEntity {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="reason")
    private String reason;

    @Column(name="percentage")
    private BigDecimal percentage;

    @Column(name="startdate")
    private Date startDate;

    @Column(name="enddate")
    private Date endDate;

    @Column(name="codecategory")
    private String category;

    public VoucherEntity() {
    }

    public VoucherEntity(String code, String reason, BigDecimal percentage, Date startDate, Date endDate, String category) {
        this.code = code;
        this.reason = reason;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

    //region getters and setters

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //endregion
}
