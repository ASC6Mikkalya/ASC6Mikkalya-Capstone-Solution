package com.ats.model;

import java.time.LocalDateTime;

public class UserCredentialsDTO {
    private String emailId;
    private String password;
    private LocalDateTime lastAttempt;
    private boolean isActive;
    public UserCredentialsDTO(){

    }
    public UserCredentialsDTO(LocalDateTime lastAttempt,boolean isActive){
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
