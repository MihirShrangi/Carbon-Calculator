package com.minor.project.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.minor.project.model.Images;
import com.minor.project.repository.uploadRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	private uploadRepository uploadRepo;
	
	@GetMapping("/write_blog")
	public String index() {
		return "write_blog";
	}
	
	@GetMapping("/publish")
	public String publish(Model m) {
		List<Images> list = uploadRepo.findAll();

		m.addAttribute("list", list);
		return "blogs";
	}
	
 
	
	@PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile img,HttpSession session,@ModelAttribute  Images im) {
		
		//Images im = new Images();
		im.setImageName(img.getOriginalFilename());
		
		Images uploadImg = uploadRepo.save(im);

		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				java.nio.file.Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
//				System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		uploadRepo.save(im);
//		System.out.println(img.getOriginalFilename());
		session.setAttribute("msg", "Image Upload Sucessfully");
		return "redirect:/publish";
	}

}
