package com.ats.controller;

import com.ats.entity.UserCredentials;
import com.ats.model.UserCredentialsDTO;
import com.ats.repository.LoginRepository;
import com.ats.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class LoginController {
    int count=0;
    private final LoginRepository loginRepository;
    private final LoginService loginService;
    @Autowired
    public LoginController(LoginRepository loginRepository,LoginService loginService){
        this.loginRepository=loginRepository;
        this.loginService=loginService;
    }
    @PostMapping("/login")
    public String verifyUser(@RequestBody UserCredentialsDTO userInfo){
        if((userInfo.getEmailId() == null)||(userInfo.getPassword() == null)){
            return "Please provide emailId and password for login";
        }
        try{
            UserCredentials loginUserDetails=loginRepository.findByEmailId(userInfo.getEmailId());
            if(loginUserDetails.getIsActive()){
                String loginStatus=loginService.checkPassWord(userInfo.getPassword(),loginUserDetails.getPassword());
                if(loginStatus.equals("Login Unsuccessful")){
                    count++;
                    if(count==3){
                        loginUserDetails.setLastAttempt(LocalDateTime.now());
                        loginUserDetails.setIsActive(false);
                        loginRepository.save(loginUserDetails);
                    }
                }
                return loginStatus;
            }
            else{
                long duration=Duration.between(loginUserDetails.getLastAttempt(), LocalDateTime.now()).toMinutes();
                if(duration>30){
                    loginUserDetails.setIsActive(true);
                    loginRepository.save(loginUserDetails);
                    return loginService.checkPassWord(userInfo.getPassword(),loginUserDetails.getPassword());
                }
                else{
                    return "Your account will be locked for "+(30-duration)+" minutes";
                }
            }
        }
        catch(NullPointerException exception){
                return "User need to be register";
        }
    }
}
