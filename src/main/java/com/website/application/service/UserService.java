package com.website.application.service;

import com.website.application.model.User;
import com.website.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSender;
    @Autowired
    PasswordEncodingService passwordEncodingService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private String userEmail,userName,userPassword;

    private Calendar calendar = new GregorianCalendar();
    private Date utilDate = new Date();
    private java.sql.Date userRegistrationDate = new java.sql.Date(utilDate.getTime());

    public UserService(){

    }

    public void saveUser(String userEmail,String userName,String userPassword){
        this.userEmail=userEmail;
        this.userName=userName;
        this.userPassword=passwordEncodingService.encode(userPassword);

        User user = new User(this.userEmail, this.userName, this.userPassword,this.userRegistrationDate);

        userRepository.save(user);
        String message = "Dear " + userName + ", you'r account was successfully created but needs activation," +
                " please redirect to link to activate your account http://localhost:8080/useractivation" +
                "\n Here is your activation code -> " + userRepository.findByUserName(userName).getUserActivationCode() +
                "\t\n Thank you for using our service" +
                "\t\n Service of Web-site.";
        mailSender.sendMail(userEmail, "Web-site account activation", message);;
    }
    public boolean userValidation(String userName,String userPassword){
        User user = userRepository.findByUserName(userName);
        return bCryptPasswordEncoder.matches(userPassword,user.getUserPassword());
    }
    public boolean userActivation(int activationCode,String userName){
        return userRepository.findByUserName(userName).getUserActivationCode() == activationCode;
    }
    public void updateUserActivation(String userName,boolean activationValue){
        User user = userRepository.findByUserName(userName);
        user.setActivated(activationValue);
        userRepository.save(user);
    }
}
