package com.duykypaul.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(path = "/chitiet", method = RequestMethod.GET)
	public String ChiTiet(@RequestParam("id") int id, @RequestParam("tensp") String tensp, ModelMap modelMap) {
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("tensp", tensp);
		return "chitiet";
	}
}
