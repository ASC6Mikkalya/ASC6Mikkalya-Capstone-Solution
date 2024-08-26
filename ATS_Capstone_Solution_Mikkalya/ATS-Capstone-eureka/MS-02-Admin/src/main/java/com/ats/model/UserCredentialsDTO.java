package com.ats.model;

public class UserCredentialsDTO {
    private String id;
    private String userName;
    private String emailId;
    private String password;
    private String phoneNumber;
    public UserCredentialsDTO(){

    }
    public UserCredentialsDTO(String id, String userName, String emailId, String password, String phoneNumber){
        this.id=id;
        this.userName=userName;
        this.emailId=emailId;
        this.password=password;
        this.phoneNumber=phoneNumber;
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
