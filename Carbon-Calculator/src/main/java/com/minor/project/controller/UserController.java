package com.minor.project.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minor.project.model.UserDtls;
import com.minor.project.model.UserfeedbackDtls;
import com.minor.project.model.UserpayDtls;
import com.minor.project.repository.UserFeedbackRepository;
import com.minor.project.repository.UserPayRepository;
import com.minor.project.repository.UserRepository;

 

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserFeedbackRepository feedbackRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserPayRepository payRepo;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}
	
	@GetMapping("/account")
	public String home1() {
		return "user/home";
	}
	
	@GetMapping("/account_after_pay")
	public String account_after_pay() {
		return "user/account_after_pay";
	}
	
	@GetMapping("/video_after_pay")
	public String video_after_pay() {
		return "user/video_after_pay";
	}
	
	@GetMapping("/feedback_after_pay")
	public String feedback_after_pay() {
		return "user/feedback_after_pay";
	}

	
	@GetMapping("/articles_after_pay")
	public String articles_after_pay() {
		return "user/articles_after_pay";
	}
	
	
	@GetMapping("/pay_email")
	public String pay_email() {
		return "user/pay_email";
	}
	
 
	@GetMapping("/Dv")
	public String p() {
		return "user/DV";
	}
	
	
	@GetMapping("/Dv_after_cc_unlock")
	public String Dv_after_cc_unlock() {
		return "user/Dv_after_cc_unlock";
	}
  
	@GetMapping("/barDGraph")
	public String barGraph(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "user/barDGraph";
		
	}
	@GetMapping("/pieDGraph")
	public String pieChart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "user/pieDGraph";
		
	}
	@GetMapping("/lineDGraph")
	public String lineChart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "user/lineDGraph";
		
 }
	@GetMapping("/livechart")
	public String livechart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "user/livechart";
		
 }
	@GetMapping("/3dBarGraph")
	public String graph(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "user/3dBarGraph";
		
 }
	@GetMapping("/Carbon_cal")
	public String C_Cal() {
		return "user/CarbonCal";
	}
	
	@GetMapping("/quiz1")
	public String quiz1() {
		return "user/quiz1";
	}
	
	@GetMapping("/quiz2")
	public String quiz2() {
		return "user/quiz2";
	}
	
	@GetMapping("/payment")
	public String payment() {
		return "user/payment";
	}
	
	@GetMapping("/unlock_cc")
	public String unlocok_cc() {
		return "user/unlock_cc";
	}
	
	@GetMapping("/video")
	public String video() {
		return "user/video";
	}
	
	@GetMapping("/articles")
	public String articles() {
		return "user/articles";
	}
	
	@GetMapping("/publish")
	public String blog() {
		return "user/blogs";
	}
	
	@GetMapping("/feedback")
	public String feedback() {
		return "user/feedback";
	}
	
	@PostMapping("/userPayment")
	public String pay(@ModelAttribute UserpayDtls u) {
		 payRepo.save(u);
		return "redirect:/pay_verify_form";
	}
	
	@PostMapping("/userFeedback")
	public String feedback_msg(@ModelAttribute UserfeedbackDtls u) {
		 
		feedbackRepo.save(u);
		return "redirect:/user_index";
	}
	
 
	
}
