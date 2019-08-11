package com.duykypaul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.duykypaul.entity.NhanVien;

@Controller
public class TrangChuController {
	
	@GetMapping
	public String Default() {
		return "trangchu";
	}
	
	@GetMapping("/{hoten}")
	public String nhanThamSo(@PathVariable String hoten, ModelMap modelMap) {
		modelMap.addAttribute("hoten", hoten);
		return "trangchu";
	}
}
