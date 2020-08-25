package com.website.application.controller;

import com.website.application.model.Post;
import com.website.application.repository.PostsRepository;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
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
    @GetMapping("/addpost")
    public String addPost(Model model){
        return "addpost";
    }
    @GetMapping("/aboutus")
    public String aboutus(Model model){
        return "aboutus";
    }
    @GetMapping("/signup")
    public String signUp(Model model){
        return "signup";
    }
    @GetMapping("/signin")
    public String signIn(Model model){
        return "signin";
    }
    @GetMapping("/profile")
    public String profile(Model model){
        return "profile";
    }
    @GetMapping("/failedtosignin")
    public String failedToSignIn(Model model){
        return "failedtosignin";
    }
    @GetMapping("/userActivation")
    public String userActivation(Model model) {
        return "userActivation";
    }
}