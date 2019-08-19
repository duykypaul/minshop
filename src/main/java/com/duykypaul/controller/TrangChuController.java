package com.duykypaul.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		/*
		 * NhanVien duyky = session.get(NhanVien.class, 34); session.delete(duyky);
		 */
		
		return "trangchu";
	}
	
}
