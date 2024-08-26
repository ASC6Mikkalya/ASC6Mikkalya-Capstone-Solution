package com.ats.service;

import com.ats.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }
    @Override
    public String generateId() {
        String adminId = adminRepository.findTopId();
        if (adminId == null || adminId.isEmpty()) {
            adminId = "AD0000";
        }
        String id="AD";
        int num=Integer.parseInt(adminId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }
    @Override
    public boolean validUserName(String userName) {
        for(Character ch:userName.toCharArray()){
            if(!((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validEmailId(String emailId) {
//        "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"
//        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
        Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(emailId);
        return matcher.matches();
    }

    @Override
    public boolean validPassword(String password) {
        if(password.length()<8) return false;
        int upperCaseCharacter=0;
        int lowerCaseCharacter=0;
        int digit=0;
        int specialCharacter=0;
        for(Character ch:password.toCharArray()){
            if((ch>='a'&&ch<='z')){
                lowerCaseCharacter++;
            }
            else if(ch>='A'&&ch<='Z'){
                upperCaseCharacter++;
            }
            else if(ch>='0'&&ch<='9'){
                digit++;
            }
            else specialCharacter++;
        }
        return (upperCaseCharacter!=0&&lowerCaseCharacter!=0&&digit!=0&&specialCharacter!=0);
    }

    @Override
    public boolean validPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=10) return false;
        for(Character ch:phoneNumber.toCharArray()){
            if(!(ch>='0'&&ch<='9')){
                return false;
            }
        }
        return true;
    }
}
