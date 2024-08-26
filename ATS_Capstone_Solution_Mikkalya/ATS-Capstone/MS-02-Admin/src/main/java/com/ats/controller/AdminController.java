package com.ats.controller;

import com.ats.entity.UserCredentials;
import com.ats.model.UserCredentialsDTO;
import com.ats.repository.AdminRepository;
import com.ats.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AdminController {
    private final AdminService adminService;
    private final AdminRepository adminRepository;
    @Autowired
    public AdminController(AdminService adminService,AdminRepository adminRepository){
        this.adminService=adminService;
        this.adminRepository=adminRepository;
    }
    @PostMapping("/admin")
    public String registerUser(@RequestBody UserCredentialsDTO userInfo){
        if(userInfo.getUserName() == null || userInfo.getEmailId() == null || userInfo.getPassword() == null || userInfo.getPhoneNumber() == null ||userInfo.getUserName().isEmpty()||userInfo.getEmailId().isEmpty()||userInfo.getPassword().isEmpty()||userInfo.getPhoneNumber().isEmpty()){
            return "All User Details must be filled";
        }
        try{
            UserCredentials userDetails=adminRepository.findByEmailId(userInfo.getEmailId());
            if(userDetails.getEmailId().equals(userInfo.getEmailId())){
                return "User EmailId already exists";
            }
            if(userDetails.getPhoneNumber().equals(userInfo.getPhoneNumber())){
                return "User Phone Number already exists";
            }
        }
        catch (NullPointerException nullPointerException){
            if(!adminService.validUserName(userInfo.getUserName())){
                return "User Name should not have number or special characters";
            }
            if(!adminService.validPassword(userInfo.getPassword())){
                return "Password should have atleast one of each uppercase character, lowercase character, digit and special character";
            }
            if(!adminService.validEmailId(userInfo.getEmailId())){
                return "EmailId should be in required format";
            }
            if(!adminService.validPhoneNumber(userInfo.getPhoneNumber())) {
                return "Phone number should have 10 digits";
            }
            String adminId=adminService.generateId();
            UserCredentials userDetails=new UserCredentials(adminId,userInfo.getUserName(),userInfo.getEmailId(),userInfo.getPassword(),userInfo.getPhoneNumber(),true);
            adminRepository.save(userDetails);
            return "User Details saved successfully";
        }
        return "";
    }
}
