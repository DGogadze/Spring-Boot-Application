package com.website.application.controller;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DatabaseController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/signup")
    public String signUp(@RequestParam String userEmail,@RequestParam String userName,@RequestParam String userPassword, Model model){
        User user = new User(userEmail,userName,userPassword);
        userRepository.save(user);
        return "home";
    }
    @GetMapping("/signin")
    public String signIn(Model model){
        return "signin";
    }
}
