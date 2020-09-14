package com.website.application.controller;

import com.website.application.repository.UserRepository;
import com.website.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUp(Model model){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String userEmail, @RequestParam String userName, @RequestParam String userPassword, Model model){
        if (userRepository.findByUserName(userName)==null&&userRepository.findByUserEmail(userEmail)==null) {
            userService.saveUser(userEmail,userName,userPassword);
            return "redirect:/useractivation";
        } else {
            model.addAttribute("userName",userName);
            model.addAttribute("userEmail",userEmail);
            return "accountExists";
        }
    }
}
