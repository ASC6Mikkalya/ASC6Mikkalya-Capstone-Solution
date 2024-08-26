package com.ats.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {
    @Id
    private String id;
    @Column(name = "User_Name",nullable = false)
    private String userName;
    @Column(name = "Email_Address",nullable = false)
    private String emailId;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "Phone_Number",nullable = false)
    private String phoneNumber;
    @Column(name = "Last_Attempt",nullable = true)
    private LocalDateTime lastAttempt;
    @Column(name = "Is_Active",nullable = true)
    private boolean isActive;
    public UserCredentials(){

    }
    public UserCredentials(String id, String userName, String emailId, String password, String phoneNumber,boolean isActive){
        this.id=id;
        this.userName=userName;
        this.emailId=emailId;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.isActive=isActive;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
