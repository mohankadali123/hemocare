package com.programerthings.firstpro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
   int hid;
   String username;
   String password;
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
