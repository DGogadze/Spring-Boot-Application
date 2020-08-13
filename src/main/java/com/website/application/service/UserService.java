package com.website.application.service;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSender;
    @Autowired
    PasswordEncodingService passwordEncodingService;

    private String userEmail,userName,userPassword;

    public UserService(){

    }

    public void saveUser(String userEmail,String userName,String userPassword){
        this.userEmail=userEmail;
        this.userName=userName;
        this.userPassword=passwordEncodingService.encode(userPassword);

        User user = new User(this.userEmail, this.userName, this.userPassword);

        userRepository.save(user);
        String message = "Dear " + userName + ", you'r account was successfully created.\n Service of Web-site.";
        mailSender.sendMail(userEmail, "Web-site account registration", message);;
    }
}
