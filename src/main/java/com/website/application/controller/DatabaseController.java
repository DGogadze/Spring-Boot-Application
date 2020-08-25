package com.website.application.controller;

import com.website.application.model.Post;
import com.website.application.model.User;
import com.website.application.repository.PostsRepository;
import com.website.application.repository.UserRepository;
import com.website.application.service.MailSenderService;
import com.website.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Controller
public class DatabaseController {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSender;
    @Autowired
    UserService userService;
    @Autowired
    PostsRepository postsRepository;

    @PostMapping("/signup")
    public String signUp(@RequestParam String userEmail,@RequestParam String userName,@RequestParam String userPassword, Model model){
        if (userRepository.findByUserName(userName)==null&&userRepository.findByUserEmail(userEmail)==null) {
            userService.saveUser(userEmail,userName,userPassword);
            return "redirect:/userActivation";
        } else {
            model.addAttribute("userName",userName);
            model.addAttribute("userEmail",userEmail);
            return "accountExists";
        }
    }
    @PostMapping("/signin")
    public String signIn(@RequestParam String userName,@RequestParam String userPassword,Model model) {
        try {
            User user = userRepository.findByUserName(userName);

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
    @PostMapping("/addpost")
    public String addPost(@RequestParam String userName,
                          @RequestParam String userPassword,
                          @RequestParam String text,
                          @RequestParam String title, Model model){
        try {
            if (userService.userValidation(userName,userPassword)){
                Calendar calendar = new GregorianCalendar();
                Date date = calendar.getTime();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                Post post = new Post(text,userName,title,sqlDate);
                postsRepository.save(post);
            }
        } catch (NullPointerException e){
            return "redirect:/failedtosignin";
        }
        return "redirect:/home";
    }
    @PostMapping("userActivation")
    public String userActivation(@RequestParam String userName,@RequestParam int activationCode){
        if (userService.userActivation(activationCode, userName)) {
            userRepository.findByUserName(userName).setActivated(true);
            return "redirect:/accountActivated";
        } else return "redirect:/userActivationFailed";
    }
}
