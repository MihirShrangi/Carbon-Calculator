package com.minor.project.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minor.project.service.EmailService;

import jakarta.servlet.http.HttpSession;


@Controller
public class RegisterVerifyController {
Random rand = new Random();
	
	@Autowired
	private EmailService emailService;
	//email id form open handler
	@RequestMapping("/email_verify")
	public String EmailForm() {
		return "email_verify";
	}
	
	@PostMapping("/get-otp")
	public String  sendOTP(@RequestParam("email") String email,jakarta.servlet.http.HttpSession session) {
		
		System.out.println("EMAIL: "+email);
		
		//generating OTP 
		int otp = rand.nextInt(1255650);
	    
	    System.out.println("OTP: "+otp);
	    
	    String subject = "OTP for  Verification";
	    String message="" +
	       "<div style='border:1px solid #e2e2e2; padding:20px'>"+
	       "<h1>"+
	       "OTP is : "+
	       "<b>"+otp+
	       "</n>"+
	       "</h1>"+
	       "</div>";
	    String to = email;
	boolean flag =   this.emailService.sendEmail(subject, message, to);
	
	if(flag) {
		session.setAttribute("myotp",otp);
		return "check_otp";
	}else {
		
		//dekhna hai thymeleaf
		session.setAttribute("message", "Check your email!!!!");
		return "email_form";
	}
	}
	
	//verify otp
	@PostMapping("/check-otp")
	public String verifyOtp(@RequestParam("otp") int otp,HttpSession session) {
		
		int myOtp=(int)session.getAttribute("myotp");
		
		if(myOtp==otp) {
		return "login";
	}else {
		
		//dekhna hai thymeleaf
		//session.setAttribute("message", "You have entered wrong otp");
		return "check-otp";
	}
	}
	
}
