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
import com.minor.project.repository.UserFeedbackRepository;
import com.minor.project.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

	@Autowired
	private UserRepository userRepo;
 
	
	@Autowired
	private UserFeedbackRepository feedbackRepo;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}
	@GetMapping("/")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/Dv")
	public String p() {
		return "admin/DV";
	}
  
	@GetMapping("/barDGraph")
	public String barGraph(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "admin/barDGraph";
		
	}
	@GetMapping("/pieDGraph")
	public String pieChart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "admin/pieDGraph";
		
	}
	@GetMapping("/lineDGraph")
	public String lineChart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "admin/lineDGraph";
		
 }
	@GetMapping("/livechart")
	public String livechart(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "admin/livechart";
		
 }
	@GetMapping("/3dBarGraph")
	public String graph(Model model){
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		
		return "admin/3dBarGraph";
		
 }
	@GetMapping("/Carbon_cal")
	public String C_Cal() {
		return "admin/CarbonCal";
	}
	
	@GetMapping("/quiz1")
	public String quiz1() {
		return "admin/quiz1";
	} 
	
	@GetMapping("/quiz2")
	public String quiz2() {
		return "admin/quiz2";
	}
	
	@GetMapping("/account")
	public String home1() {
		return "admin/home";
	}
	
	@GetMapping("/video")
	public String video() {
		return "admin/video";
	}
	
	@GetMapping("/articles")
	public String articles() {
		return "admin/articles";
	}
	
	@GetMapping("/feedback")
	public String feedback() {
		return "admin/feedback";
	}
	
	@PostMapping("/userFeedback")
	public String feedback_msg(@ModelAttribute UserfeedbackDtls u) {
		 
		feedbackRepo.save(u);
		return "redirect:/admin_index";
	}
}
