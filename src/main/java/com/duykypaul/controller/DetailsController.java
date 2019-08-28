package com.duykypaul.controller;

import com.duykypaul.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chitiet")
public class DetailsController {
	
	@GetMapping
	public String Default() {
		return "details";
	}
	
	@PostMapping
	public String updateUser(@ModelAttribute User user, ModelMap modelMap) {
		modelMap.addAttribute("user", user);
		return "details";
	}
}
