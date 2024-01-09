package com.spring.henallux.firstSpringProject.JUnit;

import com.spring.henallux.firstSpringProject.dataAccess.dao.VoucherDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.VoucherEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.VoucherRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.Voucher;
import com.spring.henallux.firstSpringProject.services.VoucherServices;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class VoucherServicesTest {

    private VoucherServices voucherServices;
    private VoucherDAO voucherDAO;

    @Mock
    private VoucherRepository voucherRepository;


    @BeforeEach
    void setUp(){
        voucherDAO = new VoucherDAO(voucherRepository,new ProviderConverter());
        voucherServices = new VoucherServices(voucherDAO);
    }

    @Test
    void findByCode() {
        VoucherEntity mockedVoucher = new VoucherEntity("Toothless", "Dragon dance successfull", new BigDecimal("0.25"), Date.valueOf("2019-01-30"), null, "Beverages");
        when(voucherRepository.findByCode("Toothless")).thenReturn(mockedVoucher);
        Voucher results = new Voucher("Toothless", "Dragon dance successfull", new BigDecimal("0.25"), Date.valueOf("2019-01-30"), null, "Beverages");
        Assert.assertEquals(mockedVoucher.getCode(), results.getCode());
        Assert.assertEquals(mockedVoucher.getReason(), results.getReason());
        Assert.assertEquals(mockedVoucher.getPercentage(), results.getPercentage());
        Assert.assertEquals(mockedVoucher.getStartDate(), results.getStartDate());
        Assert.assertEquals(mockedVoucher.getEndDate(), results.getEndDate());
        Assert.assertEquals(mockedVoucher.getCategory(), results.getCodeCategory());
    }

    @Test
    void calculateTotalPriceByCode() {
        HashMap<Product, Integer> purchases = new HashMap<>();
        VoucherEntity mockedVoucher = new VoucherEntity("Toothless", "Dragon dance successfull", new BigDecimal("0.25"), Date.valueOf("2019-01-30"), null, "Beverages");
        when(voucherRepository.findByCode("Toothless")).thenReturn(mockedVoucher);
        purchases.put(new Product(30, new BigDecimal(10), "Prod30", "Lego", "Construction"), 20);//200
        purchases.put(new Product(31, new BigDecimal(20), "Prod31", "Vodka", "Beverages"), 20);//300
        purchases.put(new Product(32, new BigDecimal(30), "Prod32", "Bac de jup", "Beverages"), 10);//225
        assertEquals(new BigDecimal("725.00"), voucherServices.calculateTotalPriceByCode("Toothless", purchases));//200 + 300 + 225 = 700
    }
}