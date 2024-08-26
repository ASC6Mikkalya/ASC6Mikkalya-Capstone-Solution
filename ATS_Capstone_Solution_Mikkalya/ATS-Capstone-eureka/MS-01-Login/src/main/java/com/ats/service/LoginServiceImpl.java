package com.ats.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private static final String LOGIN_UNSUCCESSFUL="Login Unsuccessful";
    private static final String LOGIN_SUCCESSFUL="Login SuccessFul";
    public String checkPassWord(String userPassword,String repoPassword){
        if(userPassword.equals(repoPassword)){
            return LOGIN_SUCCESSFUL;
        }
        return LOGIN_UNSUCCESSFUL;
    }
}
