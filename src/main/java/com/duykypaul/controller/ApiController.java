package com.duykypaul.controller;

import com.duykypaul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("api/")
@SessionAttributes("email")
public class ApiController {
	@Autowired
	UserService userService;
	
	@GetMapping("CheckLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		Boolean check = userService.checkLogin(email, password);
		modelMap.addAttribute("email", email);
		return "" + check;
	}
}
