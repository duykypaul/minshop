package com.duykypaul.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.duykypaul.entity.NhanVien;

@Controller
public class TrangChuController {
	
	@RequestMapping("/")
	public ModelAndView TrangChu() {
		ModelAndView viewTrangChu = new ModelAndView();
		viewTrangChu.setViewName("trangchu");
		
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien.add(new NhanVien("duykypaul", 18));
		listNhanVien.add(new NhanVien("duyky", 20));
		viewTrangChu.addObject("listnhanvien", listNhanVien);
		return viewTrangChu;
	}
}
