package com.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		
		return "access-denied";
	}

}
