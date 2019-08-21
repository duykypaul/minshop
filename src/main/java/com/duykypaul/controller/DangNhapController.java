package com.duykypaul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duykypaul.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	
	@GetMapping
	public String Default() {
		return "dangnhap";
	}
	
	@Autowired
	NhanVienService nhanVienService;
	
	@PostMapping
	@Transactional
	public String xuLiDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap ) {
		
		Boolean check = nhanVienService.kiemTraDangNhap(email, matkhau);
		modelMap.addAttribute("checkLogin", (check) ? "login success !" : "login failed !");
		return "dangnhap";
	}
}
