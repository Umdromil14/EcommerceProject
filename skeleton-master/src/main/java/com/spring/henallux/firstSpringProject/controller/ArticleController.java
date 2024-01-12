package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.Quantity;
import com.spring.henallux.firstSpringProject.services.CategoryTranslationServices;
import com.spring.henallux.firstSpringProject.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/article/{id}")
@SessionAttributes("basket")
public class ArticleController {

    @ModelAttribute("basket")
    public HashMap<Product,Integer> basket() {
        return new HashMap<>();
    }

    private final CategoryTranslationServices categoryTranslationServices;
    private final ProductServices productServices;

    @Autowired
    public ArticleController(CategoryTranslationServices categoryTranslationServices, ProductServices productServices) {
        this.categoryTranslationServices = categoryTranslationServices;
        this.productServices = productServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String article(Model model, Locale locale, @PathVariable(value = "id") Integer id, HttpSession session) {
        model.addAttribute("quantityPurchased", new Quantity());
        model.addAttribute("product", productServices.getProductById(id));
        model.addAttribute("categories", categoryTranslationServices.getAllCategories(locale.getLanguage()));

        HashMap<Product,Integer> purchases = (HashMap<Product,Integer>) session.getAttribute("basket");
        Integer purchasesCount = productServices.getPurchasesCount(purchases);

        model.addAttribute("basketFull", purchasesCount >= Constants.MAX_PURCHASES);
        model.addAttribute("max", Constants.MAX_PURCHASES - purchasesCount);
        return "integrated:article";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct (
        @Valid @ModelAttribute(value="quantityPurchased") Quantity quantityPurchased,
        @PathVariable(value="id") Integer articleID,
        final BindingResult errors,
        HttpSession session
    ) {
        HashMap<Product,Integer> purchases = (HashMap<Product,Integer>) session.getAttribute("basket");
        Product product = productServices.getProductById(articleID);
        Integer max = Constants.MAX_PURCHASES - productServices.getPurchasesCount(purchases);
        if (!errors.hasErrors() && max > 0 && quantityPurchased.getQuantity() > 0){
            if(quantityPurchased.getQuantity() > max){
                quantityPurchased.setQuantity(max);
            }
            session.setAttribute("basket", productServices.addProductToBasket(purchases, product, quantityPurchased.getQuantity()));
        }
        return "redirect:/article/" + articleID;
    }
}
