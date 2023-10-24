package com.programerthings.firstpro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hospitals {
	@Id 
	int hid;
	
	String hospitalName;
	String hospitalAddress;
	int pincode;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Hospitals [hid=" + hid + ", hospitalName=" + hospitalName + ", hospitalAddress=" + hospitalAddress
				+ ", pincode=" + pincode + "]";
	}
	
}
