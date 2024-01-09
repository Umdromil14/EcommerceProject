package com.spring.henallux.firstSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/about")
public class AboutController {

    @RequestMapping
    public String about(){
        return "integrated:about";
    }

}
