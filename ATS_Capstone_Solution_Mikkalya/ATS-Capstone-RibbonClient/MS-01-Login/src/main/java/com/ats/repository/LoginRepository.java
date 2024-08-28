package com.ats.repository;

import com.ats.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserCredentials,String> {
    UserCredentials findByEmailId(String emailId);
}
