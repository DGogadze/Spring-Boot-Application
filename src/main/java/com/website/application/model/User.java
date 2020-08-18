package com.website.application.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class User {
    public User(String userEmail, String userName, String userPassword, Date userRegistrationDate) {
        setUserName(userName);
        setUserPassword(userPassword);
        setUserEmail(userEmail);
        setUserRegistrationDate(userRegistrationDate);
    }
    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date userRegistrationDate;

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
