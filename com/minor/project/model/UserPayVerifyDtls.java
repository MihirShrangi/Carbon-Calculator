package com.minor.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserPayVerifyDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	
	private String email;
  
	private String Captcha;
	
	private boolean enabled;
	
	private int verificationCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaptcha() {
		return Captcha;
	}

	public void setCaptcha(String captcha) {
		Captcha = captcha;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		return "UserPayVerifyDtls [id=" + id + ", fname=" + fname + ", email=" + email + ", Captcha=" + Captcha
				+ ", enabled=" + enabled + ", verificationCode=" + verificationCode + "]";
	}
	
	 
}
