package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.CategoryTranslation;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.Quantity;
import com.spring.henallux.firstSpringProject.services.CategoryTranslationServices;
import com.spring.henallux.firstSpringProject.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/catalog/{category}")
@SessionAttributes("basket")
public class CatalogController {

    @ModelAttribute("basket")
    public HashMap<Product,Integer> basket() {
        return new HashMap<>();
    }
    private final ProductServices productServices;
    private final CategoryTranslationServices categoriesTranslationServices;

    @Autowired
    public CatalogController(ProductServices productServices, CategoryTranslationServices categoriesTranslationServices){
        this.productServices = productServices;
        this.categoriesTranslationServices = categoriesTranslationServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String catalog (Model model, Locale locale, @PathVariable(value="category") String category, HttpSession session) {
        ArrayList<CategoryTranslation> categories = categoriesTranslationServices.getAllCategories(locale.getLanguage());
        model.addAttribute("category", category);
        for (CategoryTranslation categoryTranslation : categories) {
            if(categoryTranslation.getCategory().equals(category)){
                model.addAttribute("categoryTitle", categoryTranslation.getLabel());
            }
        }

        model.addAttribute("quantityPurchased", new Quantity());
        model.addAttribute("categories", categories);
        model.addAttribute("products", productServices.getAllSellsByCategory(category));

        HashMap<Product,Integer> purchases = (HashMap<Product,Integer>) session.getAttribute("basket");
        int purchasesCount = productServices.getPurchasesCount(purchases);
        model.addAttribute("basketFull", purchasesCount >= Constants.MAX_PURCHASES);
        model.addAttribute("max", Constants.MAX_PURCHASES - purchasesCount);

        return "integrated:catalog";
    }

    @RequestMapping(value="/add/{id}", method = RequestMethod.POST)
    public String addToBasket (
        @Valid @ModelAttribute(value="quantityPurchased") Quantity quantityPurchased,
        final BindingResult errors,
        @PathVariable(value="category") String category,
        @PathVariable(value="id") Integer articleID,
        HttpSession session
        ) {
        HashMap<Product,Integer> purchases = (HashMap<Product,Integer>) session.getAttribute("basket");
        int max = Constants.MAX_PURCHASES - productServices.getPurchasesCount(purchases);
        Product product = productServices.getProductById(articleID);

        if (!errors.hasErrors() && max > 0 && quantityPurchased.getQuantity() > 0) {
            if(quantityPurchased.getQuantity() > max){
                quantityPurchased.setQuantity(max);
            }
            session.setAttribute("basket", productServices.addProductToBasket(purchases, product, quantityPurchased.getQuantity()));
        }

        return "redirect:/catalog/" + category;
        }
}