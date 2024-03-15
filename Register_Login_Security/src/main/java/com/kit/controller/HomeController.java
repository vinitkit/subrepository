package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kit.entity.User;
import com.kit.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String index() {
		
	return "index";
	}
	@GetMapping("/register")
	public String register() {
		
		return "register";
		}
	@GetMapping("/signin")
	public String login() {
		
		return "login";
		}
	@GetMapping("/profile")
	public String profile() {
		
		return "index";
		}
	@GetMapping("/home")
	public String home() {
		
		return "home";
		}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {	//, Model m

	//	System.out.println(user);

		User u = userService.saveUser(user);

		if (u != null) {
			// System.out.println("save sucess");
			session.setAttribute("msg", "Register successfully");

		} else {
			//System.out.println("error in server");
		session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}
}
	
	
