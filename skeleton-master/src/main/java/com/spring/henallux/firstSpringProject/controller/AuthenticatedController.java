package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.services.CategoryTranslationServices;
import com.spring.henallux.firstSpringProject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/authenticated")
public class AuthenticatedController {

    private final UserServices userServices;

    private final CategoryTranslationServices categoriesTranslationServices;

    private final UserDataAccess userDAO;

    @Autowired
    public AuthenticatedController(UserServices userServices, CategoryTranslationServices categoriesTranslationServices, UserDataAccess userDAO){
        this.userServices = userServices;
        this.categoriesTranslationServices = categoriesTranslationServices;
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String authenticated (Authentication authentication, Model model, Locale locale) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", userServices.findByUsername(user.getUsername()));
        model.addAttribute("categories", categoriesTranslationServices.getAllCategories(locale.getLanguage()));
        return "integrated:authenticated";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getNewUserDetails(Model model, Authentication authentication, @Valid @ModelAttribute(value="user") User form,
                                    final BindingResult errors){
        User user = (User) authentication.getPrincipal();
        if (errors.hasErrors()) {
            System.out.println(form.getLastname());
            return "integrated:authenticated";
        }
        System.out.println(user.getLastname());

        userServices.updateUser(user.getUsername(), form.getLastname(), form.getFirstname(), form.getAddress(), form.getEmail());

        return "redirect:/home";
    }
}
