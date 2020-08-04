package com.website.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    public User(String userEmail, String userName, String userPassword) {
        setUserName(userName);
        setUserPassword(userPassword);
        setUserEmail(userEmail);
    }
    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String userName;

    private String userPassword;

    private String userEmail;

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
