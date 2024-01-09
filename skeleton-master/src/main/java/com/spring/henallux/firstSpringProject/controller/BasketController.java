package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.*;
import com.spring.henallux.firstSpringProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/basket")
@SessionAttributes({"basket", "voucherCode"})
public class BasketController {

    @ModelAttribute("basket")
    public HashMap<Product,Integer> basket(){
        return new HashMap<Product,Integer>();
    }

    @ModelAttribute("voucherCode")
    public String voucherCode(){return null;}

    private VoucherServices voucherServices;

    private OrderServices orderServices;

    private TransactionDetailServices transactionDetailServices;

    private ReductionServices reductionServices;

    private ProductServices productServices;

    @Autowired
    public BasketController(VoucherServices voucherServices,OrderServices orderServices, TransactionDetailServices transactionDetailServices, ReductionServices reductionServices, ProductServices productServices){
        this.voucherServices = voucherServices;
        this.orderServices = orderServices;
        this.transactionDetailServices = transactionDetailServices;
        this.reductionServices = reductionServices;
        this.productServices = productServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String basket (Model model, HttpSession session) {
        session.setAttribute("voucherCode", null);

        HashMap<Product,Integer> purchases = (HashMap<Product,Integer>) session.getAttribute("basket");
        double totalPayment = 0.0;
        int purchasesCount = 0;
        if (purchases != null) {
            for (Product product : purchases.keySet()) {
                totalPayment += product.getPrice().doubleValue() * purchases.get(product).doubleValue();
                purchasesCount += purchases.get(product);
            }
        }

        model.addAttribute("totalPaymentWithoutVoucher", Math.round(totalPayment * 100.0) / 100.0);
        model.addAttribute("purchases", purchases);
        model.addAttribute("updateArticle", new Quantity());
        model.addAttribute("voucher", new Voucher());
        model.addAttribute("basketFull", purchasesCount >= Constants.MAX_PURCHASES);
        model.addAttribute("max", Constants.MAX_PURCHASES - purchasesCount);

        return "integrated:basket";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String basketUpdateArticle(
            @Valid @ModelAttribute(value = "updateArticle") Quantity updatedArticle,
            HttpSession session,
            BindingResult errors,
            @PathVariable(value="id") Integer articleID
    ){
        HashMap<Product, Integer> purchases = (HashMap<Product, Integer>) session.getAttribute("basket");
        int max = (Constants.MAX_PURCHASES - productServices.getPurchasesCount(purchases));

        if (!errors.hasErrors()){
            Product updatedProduct = null;
            for (Map.Entry<Product, Integer> purchase : purchases.entrySet()) {
                if (purchase.getKey().getID().equals(articleID)) {
                    if (updatedArticle.getQuantity() <= 0) {
                        updatedProduct = purchase.getKey();
                    } else {
                        int maxForThisProduct = max + purchase.getValue();
                        if(maxForThisProduct < updatedArticle.getQuantity()){
                            updatedArticle.setQuantity(maxForThisProduct);
                        }
                        purchases.put(purchase.getKey(), updatedArticle.getQuantity());
                    }
                    break;
                }
            }
            if(updatedProduct != null){
                purchases.remove(updatedProduct);
                if (purchases.isEmpty()){
                    return "redirect:/home";
                }
            }
        }
        return "redirect:/basket";
    }

    @RequestMapping(value="/addVoucher", method = RequestMethod.POST)
    public String basketAddVoucher(
            @ModelAttribute(value="voucher") Voucher voucher,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        BigDecimal reduction = voucherServices.calculateTotalPriceByCode(voucher.getCode(), (HashMap< Product, Integer>) session.getAttribute("basket"));
        if (reduction.intValue() != -1){
            redirectAttributes.addFlashAttribute("totalPayment", reduction.setScale(2, RoundingMode.CEILING));
            session.setAttribute("voucherCode", voucher.getCode());
        }
        else{
            session.setAttribute("voucherCode", null);
            redirectAttributes.addFlashAttribute("wentIn", true);
        }
        return "redirect:/basket";
    }

    @RequestMapping(value="/success", method = RequestMethod.GET)
    public String paymentSuccess(Authentication authentication, HttpSession session){
        User user = (User) authentication.getPrincipal();
        Order order = new Order(user.getID(), new Date(), true);
        Integer orderId = orderServices.insertOrder(order);

        String code = (String) session.getAttribute("voucherCode");
        if(code != null){
            Reduction reduction = new Reduction(orderId, code);
            reductionServices.insertReduction(reduction);
        }

        Voucher voucher = voucherServices.findByCode(code);
        HashMap<Product, Integer> purchases = (HashMap< Product, Integer>) session.getAttribute("basket");
        for(Map.Entry<Product, Integer> purchase: purchases.entrySet()){
            Product product = purchase.getKey();
            BigDecimal transactionPrice;
            if(code != null && product.getCategory().equals(voucher.getCodeCategory())){
                transactionPrice = product.getPrice().multiply(new BigDecimal(1).subtract(voucher.getPercentage()));
            }
            else {
                transactionPrice = product.getPrice();
            }
            transactionPrice = transactionPrice.setScale(2, RoundingMode.CEILING);
            TransactionDetail transaction = new TransactionDetail(purchase.getValue(), transactionPrice, product.getID(), orderId);
            transactionDetailServices.insertTransactionDetail(transaction);
        }

        purchases.clear();
        session.setAttribute("basket", purchases);
        return "integrated:successPayment";
    }

    @RequestMapping(value="/failure", method = RequestMethod.GET)
    public String paymentFailure(){
        return "integrated:paymentFailure";
    }
}
