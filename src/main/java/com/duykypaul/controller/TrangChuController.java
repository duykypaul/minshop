package com.duykypaul.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duykypaul.entity.NhanVien;

@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping
	@Transactional
	public String Default() {

		Session session = sessionFactory.getCurrentSession();
		
		NhanVien suka = (NhanVien) session.createQuery("from NhanVien WHERE idNhanVien = 4").uniqueResult();
		suka.setTuoi(25);
		session.update(suka);
		suka = session.get(NhanVien.class, 4);
		suka.setTenNhanVien("suka beau");
		session.update(suka);
		return "trangchu";
	}
	
}
