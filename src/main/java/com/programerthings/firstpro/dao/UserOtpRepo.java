package com.programerthings.firstpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.programerthings.firstpro.model.UserOtp;

public interface UserOtpRepo extends JpaRepository<UserOtp, Integer>{
    UserOtp findByEmail(String email);
}
