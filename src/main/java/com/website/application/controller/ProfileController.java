package com.website.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile(Model model){
        return "profile";
    }
    @PostMapping("/profile")
    public String profile(){
        return "profile";
    }
}
