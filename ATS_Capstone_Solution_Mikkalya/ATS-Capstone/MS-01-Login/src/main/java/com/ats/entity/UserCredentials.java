package com.ats.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user_credentials")
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
    public UserCredentials(LocalDateTime lastAttempt,boolean isActive){
        this.lastAttempt=lastAttempt;
        this.isActive=isActive;
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
    public LocalDateTime getLastAttempt() {
        return lastAttempt;
    }
    public void setLastAttempt(LocalDateTime lastAttempt) {
        this.lastAttempt = lastAttempt;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}