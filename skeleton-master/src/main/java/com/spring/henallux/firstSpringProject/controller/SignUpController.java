package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value="/signup")
public class SignUpController {
    private UserDataAccess userDAO;

    @Autowired
    public SignUpController(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("usernameExists", false);
        model.addAttribute("passwordNotRepeats", false);
        return "integrated:signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData (Model model, @Valid @ModelAttribute(value="user") User user, final BindingResult errors) {
        boolean hasErrors = false;
        if (userDAO.usernameExists(user.getUsername())) {
            model.addAttribute("usernameExists", true);
            hasErrors = true;
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordNotRepeats", true);
            hasErrors = true;
        }

        if (errors.hasErrors() || hasErrors) {
            return "integrated:signup";
        }

        user.setUserDefaultValues();
        userDAO.createUser(user);

        return "redirect:/login";
    }
}