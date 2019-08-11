package com.duykypaul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duykypaul.entity.NhanVien;

@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@GetMapping
	public String Default() {
		return "trangchu";
	}
	
}
