package com.programerthings.firstpro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BloodBank {
    @Id 
	int hid;
	int apos;
	int bpos;
	int opos;
	int abpos;
	int aneg;
	int bneg;
	int abneg;
	int oneg;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getApos() {
		return apos;
	}
	public void setApos(int apos) {
		this.apos = apos;
	}
	public int getBpos() {
		return bpos;
	}
	public void setBpos(int bpos) {
		this.bpos = bpos;
	}
	public int getOpos() {
		return opos;
	}
	public void setOpos(int opos) {
		this.opos = opos;
	}
	public int getAbpos() {
		return abpos;
	}
	public void setAbpos(int abpos) {
		this.abpos = abpos;
	}
	public int getAneg() {
		return aneg;
	}
	public void setAneg(int aneg) {
		this.aneg = aneg;
	}
	public int getBneg() {
		return bneg;
	}
	public void setBneg(int bneg) {
		this.bneg = bneg;
	}
	public int getAbneg() {
		return abneg;
	}
	public void setAbneg(int abneg) {
		this.abneg = abneg;
	}
	public int getOneg() {
		return oneg;
	}
	public void setOneg(int oneg) {
		this.oneg = oneg;
	}
	public String toString() {
		return "BloodBank [hid=" + hid + ", apos=" + apos + ", bpos=" + bpos + ", opos=" + opos + ", abpos=" + abpos
				+ ", aneg=" + aneg + ", bneg=" + bneg + ", abneg=" + abneg + ", oneg=" + oneg + "]";
	}
	
	
	
}
