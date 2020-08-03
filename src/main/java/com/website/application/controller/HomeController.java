package com.website.application.controller;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
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
    @GetMapping("/getdata")
    public String getData(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "home";
    }
}