package com.website.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FailureSignInController {
    @GetMapping("/failedtosignin")
    public String failedToSignIn(Model model){
        return "failedtosignin";
    }
}
