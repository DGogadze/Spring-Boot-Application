package com.website.application.controller;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import com.website.application.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DatabaseController {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSender mailSender;

    @PostMapping("/signup")
    public String signUp(@RequestParam String userEmail,@RequestParam String userName,@RequestParam String userPassword, Model model){
        User user = new User(userEmail,userName,userPassword);
        user.setUserPassword(bCryptPasswordEncoder.encode(userPassword));
        userRepository.save(user);
        String message = "Dear " + userName + ", you'r account was successfully created.\n Service of Web-site.";
        mailSender.sendMail(userEmail,"Web-site account registration",message);
        return "signin";
    }
    @PostMapping("/signin")
    public String signIn(@RequestParam String userName,@RequestParam String userPassword,Model model){
        User user = userRepository.findByUserName(userName);
        if (bCryptPasswordEncoder.matches(userPassword,user.getUserPassword())){
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("userEmail",user.getUserEmail());
            model.addAttribute("userID",user.getUserID());
        }
        return "profile";
    }
}
