package com.duykypaul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duykypaul.dao.NhanVienDao;
import com.duykypaul.dao.impl.NhanVienImpl;

@Service
public class NhanVienService implements NhanVienImpl  {
	
	@Autowired
	NhanVienDao nhanVienDao;

	@Override
	public Boolean kiemTraDangNhap(String email, String matkhau) {
		return nhanVienDao.kiemTraDangNhap(email, matkhau);
	}
	
	
	
}
