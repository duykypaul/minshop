package com.duykypaul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("email")
public class TrangChuController {

	

	@GetMapping
	public String Default() {
		
		return "trangchu";
	}
	
}
