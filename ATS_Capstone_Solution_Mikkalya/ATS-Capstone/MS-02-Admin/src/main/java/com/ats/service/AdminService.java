package com.ats.service;

public interface AdminService {
    boolean validUserName(String userName);
    boolean validEmailId(String emailId);
    boolean validPassword(String password);
    boolean validPhoneNumber(String phoneNumber);
    String generateId();
}
