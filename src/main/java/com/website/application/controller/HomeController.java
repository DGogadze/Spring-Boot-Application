package com.website.application.controller;

import com.website.application.model.Post;
import com.website.application.repository.PostsRepository;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    UserRepository user;
    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Post> posts = postsRepository.findAll();
        model.addAttribute("posts",posts);
        return "home";
    }
    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Post> posts = postsRepository.findAll();
        model.addAttribute("posts",posts);
        return "home";
    }
}