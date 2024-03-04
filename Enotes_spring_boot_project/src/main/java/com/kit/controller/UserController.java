package com.kit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/addNotes")
	public String addNotes() {
		
		
		return "add_notes";
	}
	
	@GetMapping("/viewNotes")
	public String viewNotes() {
		
		
		return "view_notes";
	}
	
	@GetMapping("/editNotes")
	public String editNotes() {
		
		
		return "edit_notes";
	}

}
