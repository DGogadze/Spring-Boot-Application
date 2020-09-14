package com.website.application.controller;

import com.website.application.model.Post;
import com.website.application.repository.PostsRepository;
import com.website.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class AddPostController {
    @Autowired
    UserService userService;

    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/addpost")
    public String addPost(Model model){
        return "addpost";
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
}
