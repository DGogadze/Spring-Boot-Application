package com.website.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountActivatedController {
    @GetMapping("/accountactivated")
    public String accountActivated(Model model){
        return "accountactivated";
    }
}
