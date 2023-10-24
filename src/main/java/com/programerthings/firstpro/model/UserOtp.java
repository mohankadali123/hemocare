package com.programerthings.firstpro.model;

import org.springframework.stereotype.Controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserOtp {

	@Id
	String email;
	String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
}
