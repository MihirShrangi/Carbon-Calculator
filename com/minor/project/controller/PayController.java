package com.minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.minor.project.model.UserPayVerifyDtls;
import com.minor.project.repository.UserPayVerifyRepository;
import com.minor.project.service.PayService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PayController {
	@Autowired
	private PayService userService;
	
	@Autowired
	private UserPayVerifyRepository userpvRepo;
	
	@GetMapping("/pay_verify_form")
	public String index() {
		return "pay";
	}
	
//	@PostMapping("/payVerify")
//	public String pay(@ModelAttribute UserPayVerifyDtls u) {
//	//	System.out.println(u);
//		userpvRepo.save(u);
//		return "redirect:/";
//	}
	
	
	@PostMapping("/payVerify")
	public String createuser(@ModelAttribute UserPayVerifyDtls user,HttpServletRequest request) {
		
		String url = request.getRequestURL().toString(); 
		//http://localhost:8080/payVerify
		
		url=url.replace(request.getServletPath(), "");
		
		UserPayVerifyDtls userDtls = userService.createUser(user,url);
			if (userDtls != null) {
			System.out.println("");
		} else {
			System.out.println("Something wrong on server");
		}
          return "redirect:user/pay_email";  
	}
	
	@GetMapping("/verify")
	public String VerifyPayment(@Param("code") String code) {
		if(userService.verifyPayment(code)) {
			return "thanks";
		}
		return "failed";
	}
}
