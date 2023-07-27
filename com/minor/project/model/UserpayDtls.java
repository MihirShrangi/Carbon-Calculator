package com.minor.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_PAY")
public class UserpayDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String cno;
   private String cname;
   private String expirem;
   private String expirey;
   private String cvv;
   private String amt;
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getExpirem() {
	return expirem;
}
public void setExpirem(String expirem) {
	this.expirem = expirem;
}
public String getExpirey() {
	return expirey;
}
public void setExpirey(String expirey) {
	this.expirey = expirey;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getAmt() {
	return amt;
}
public void setAmt(String amt) {
	this.amt = amt;
}

@Override
public String toString() {
	return "UserpayDtls [id=" + id + ", cno=" + cno + ", cname=" + cname + ", expirem=" + expirem + ", expirey="
			+ expirey + ", cvv=" + cvv + ", amt=" + amt + "]";
}
   
   
}
