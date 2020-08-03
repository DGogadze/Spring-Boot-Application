package com.website.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/aboutus")
    public String aboutUs(Model model){
        return "aboutus";
    }
    @GetMapping("/enterprise")
    public String enterprise(Model model){
        return "enterprise";
    }
    @GetMapping("/prising")
    public String prising(Model model){
        return "prising";
    }
    @GetMapping("/support")
    public String support(Model model){
        return "support";
    }
}