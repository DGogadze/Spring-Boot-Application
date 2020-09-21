package com.website.application.controller;

import com.website.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserActivationController {
    @Autowired
    UserService userService;

    @GetMapping("/useractivation")
    public String userActivation(Model model){
        return "useractivation";
    }

    @PostMapping("/useractivation")
    public String userActivation(@RequestParam String userName, @RequestParam int activationCode){
        if (userService.userActivation(activationCode, userName)) {
            userService.updateUserActivation(userName,true);
            return "redirect:/accountactivated";
        } else return "redirect:/useractivationfailed";
    }
}
