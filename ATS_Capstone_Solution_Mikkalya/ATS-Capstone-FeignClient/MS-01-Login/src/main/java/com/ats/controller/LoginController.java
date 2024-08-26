package com.ats.controller;

import com.ats.entity.UserCredentials;
import com.ats.model.BookingDTO;
import com.ats.model.UserCredentialsDTO;
import com.ats.proxy.LoginProxy;
import com.ats.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class LoginController {
    int count=0;
    private final LoginProxy loginProxy;
    private final LoginRepository loginRepository;
    @Autowired
    public LoginController(LoginRepository loginRepository,LoginProxy loginProxy){
        this.loginRepository=loginRepository;
        this.loginProxy=loginProxy;
    }
    private boolean checkValidity(UserCredentialsDTO userInfo){
        return ((userInfo.getEmailId() == null)||(userInfo.getPassword() == null));
    }
    @PostMapping("/login")
    public List<BookingDTO> verifyUser(@RequestBody UserCredentialsDTO userInfo){
        if(checkValidity(userInfo)){
            return null;
        }
        try{
            UserCredentials loginUserDetails=loginRepository.findByEmailId(userInfo.getEmailId());
            if(loginUserDetails.getIsActive()){
                if(userInfo.getPassword().equals(loginUserDetails.getPassword())){
                    return loginProxy.getAllBooking();
                }
                else{
                    count++;
                    if(count==3){
                        loginUserDetails.setLastAttempt(LocalDateTime.now());
                        loginUserDetails.setIsActive(false);
                        loginRepository.save(loginUserDetails);
                    }
                }
            }
            else{
                long duration=Duration.between(loginUserDetails.getLastAttempt(), LocalDateTime.now()).toMinutes();
                if(duration>30){
                    loginUserDetails.setIsActive(true);
                    loginRepository.save(loginUserDetails);
                    if(userInfo.getPassword().equals(loginUserDetails.getPassword())){
                        return loginProxy.getAllBooking();
                    }
                }
            }
        }
        catch(NoSuchElementException exception){
                return null;
        }
        return null;
    }
}
