package com.minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minor.project.model.UserDtls;
import com.minor.project.model.UserfeedbackDtls;
import com.minor.project.model.UserpayDtls;
import com.minor.project.repository.UserFeedbackRepository;
import com.minor.project.repository.UserPayRepository;
 
import com.minor.project.repository.UserRepository;
 
import com.minor.project.service.UserService;
 
 
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
    
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserPayRepository payRepo;
	
	 
	
	@Autowired
	private UserFeedbackRepository feedbackRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	 
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}
	
	@GetMapping("/thanks")
	public String thanks() {
		return "thanks";
	}
	
	@GetMapping("/graph")
	public String graph() {
		return "graph";
	}
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	@GetMapping("/data")
	public String data() {
		return "data";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "blog";
	}
	
	@GetMapping("/video")
	public String video() {
		return "video";
	}
	
	@GetMapping("/articles")
	public String articles() {
		return "articles";
	}
	 
	@GetMapping("/user_index")
	public String user_index() {
		return "user_index";
	}
	
	@GetMapping("/admin_index")
	public String admin_index() {
		return "admin_index";
	}
	
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session,Model model) {
		
	//	System.out.println(user);
		
		boolean status = userService.checkEmail(user.getEmail());

		if (status) {
			
			System.out.println("Email Id alreday exists");
			return "error";
		 
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
				System.out.println("Register Sucessfully");
			} else {
				System.out.println("Something wrong on server");
			}
		}
		return "redirect:/email_verify";
	}
	
	
	@GetMapping("/loadResetPassword/{id}")
	public String loadResetPassword(@PathVariable int id,Model m) {
		 m.addAttribute("id",id);
		return "reset_password";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email,@RequestParam String mobileNum, HttpSession session) {
		
		UserDtls user = userRepo.findByEmailAndMobileNumber(email,mobileNum);
		
		if(user!=null) {
			return "redirect:/loadResetPassword/" +user.getId();
		}else {
	 
		return "forgot_password";
	}
}
	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw,@RequestParam Integer id) {
		
		UserDtls user = userRepo.findById(id).get();
		String encryptPsw=passwordEncoder.encode(psw);
		
		user.setPassword(encryptPsw);
		
	UserDtls updateUser = userRepo.save(user);
	
	if(updateUser !=null) {
		return "login";
	}
		return "redirect:/loadResetPassword";
	}
	
	
//	@PostMapping("/userPayment")
//	public String pay(@ModelAttribute UserpayDtls u) {
//		 payRepo.save(u);
//		return "redirect:/par_verify_form";
//	}
	
	@PostMapping("/userFeedback")
	public String feedback_msg(@ModelAttribute UserfeedbackDtls u) {
		 
		feedbackRepo.save(u);
		return "redirect:/";
	}
	
	@GetMapping("/blog_user_login")
	public String blog_user_login() {
		return "blog_user_login";
	}
	
	@GetMapping("/write_blog_user")
	public String  write_blog_user() {
		return "write_blog_user";
	}
	
	@GetMapping("/user_index_after_pay")
	public String  user_index_after_pay() {
		return "user_index_after_pay";
	}
}
