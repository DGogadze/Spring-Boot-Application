package com.website.application.controller;

import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository user;
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/addpost")
    public String addPost(Model model){
        return "addpost";
    }
    @GetMapping("/aboutus")
    public String aboutus(Model model){
        return "aboutus";
    }
    @GetMapping("/signup")
    public String signUp(Model model){
        return "signup";
    }
    @GetMapping("/signin")
    public String signIn(Model model){
        return "signin";
    }
    @GetMapping("/profile")
    public String profile(Model model){
        return "profile";
    }
    @GetMapping("/failedtosignin")
    public String failedToSignIn(Model model){
        return "failedtosignin";
    }
}