package com.minor.project.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.minor.project.model.UserPayVerifyDtls;
import com.minor.project.repository.UserPayVerifyRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class PayServiceImpl implements PayService {
	
	@Autowired
	private UserPayVerifyRepository userpvRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public UserPayVerifyDtls  createUser(UserPayVerifyDtls  user,String url) {

		user.setEnabled(false);
		
		Random ran = new Random();
		
	    int otp = ran.nextInt(1255650);
	     
		user.setVerificationCode(otp);  //random generation dekhna hai
		
		UserPayVerifyDtls us = userpvRepo.save(user);
		
		sendVerificationMail(user,url);
		return us;
		
	}
	
	
	public void sendVerificationMail(UserPayVerifyDtls user,String url) {
		String from ="priya20031810@gmail.com";
		String to=user.getEmail();
		String subject="Payment Verification";
		String content="<div style='border:1px solid #e2e2e2; padding:20px'>"
		+"<b><h3>Dear [[name]]</h3></b>"
		+"<h2>Please click the link below to verify your payment:</h2>"
		+"<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY YOUR PAYMENT</a></h3>"
		+"Thank You<br>"
		+"ESM WEBSITE"+
		"</div>";  
		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			
			helper.setFrom(from,"Priya");
			helper.setTo(to);
			helper.setSubject(subject);
			
			
			content=content.replace("[[name]]", user.getFname());
			
			String siteUrl=url+"/verify?code="+user.getVerificationCode();
			content = content.replace("[[URL]]", siteUrl);
			
			helper.setText(content,true);
			
			mailSender.send(message);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
	 }
	}


	@Override
	public boolean verifyPayment(String code) {
		UserPayVerifyDtls user = userpvRepo.findByverificationCode(code);
		
		if(user!=null) {
			
			user.setEnabled(true);
			//user.setVerificationCode(null);
			
			userpvRepo.save(user);
			return true;
		}
		return false;
	}
	
  
}
