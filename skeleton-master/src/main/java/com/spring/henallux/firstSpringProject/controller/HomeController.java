package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.services.CategoryTranslationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    private final CategoryTranslationServices categoriesTranslationServices;

    @Autowired
    public HomeController(CategoryTranslationServices categoriesTranslationServices){
        this.categoriesTranslationServices = categoriesTranslationServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model,Locale locale) {
        model.addAttribute("categories", categoriesTranslationServices.getAllCategories(locale.getLanguage()));
        return "integrated:home";
    }

}
