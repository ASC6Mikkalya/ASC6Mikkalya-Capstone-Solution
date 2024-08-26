package com.ats.repository;

import com.ats.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<UserCredentials,String> {
    UserCredentials findByEmailId(String emailId);
    @Query(value = "SELECT id FROM user_credentials ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
}
