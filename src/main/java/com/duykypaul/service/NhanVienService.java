package com.duykypaul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duykypaul.dao.NhanVienDao;
import com.duykypaul.dao.inf.INhanVien;
import com.duykypaul.entity.NhanVien;

@Service
public class NhanVienService implements INhanVien  {
	
	@Autowired
	NhanVienDao nhanVienDao;

	@Override
	public Boolean kiemTraDangNhap(String email, String matkhau) {
		return nhanVienDao.kiemTraDangNhap(email, matkhau);
	}

	@Override
	public Boolean themNhanVien(NhanVien nhanVien) {
		
		return nhanVienDao.themNhanVien(nhanVien);
	}
	
}
