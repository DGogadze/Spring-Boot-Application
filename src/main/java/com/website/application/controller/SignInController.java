package com.website.application.controller;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import com.website.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/signin")
    public String signIn(Model model){
        return "signin";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String userName, @RequestParam String userPassword, Model model) {
        try {
            User user = userRepository.findByUserName(userName);

            if (!user.isActivated()){
                return "redirect:/useractivation";
            }

            if (userService.userValidation(userName, userPassword)) {
                model.addAttribute("userID", user.getUserID());
                model.addAttribute("userName", userName);
                model.addAttribute("userEmail", user.getUserEmail());
                model.addAttribute("userRegistrationDate", user.getUserRegistrationDate());
                model.addAttribute("title","Website : " + userName);
                return "profile";
            }
        } catch (NullPointerException e) {
            return "failedtosignin";
        }
        return "failedtosignin";
    }
}
