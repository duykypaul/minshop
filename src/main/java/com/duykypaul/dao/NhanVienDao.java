package com.duykypaul.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duykypaul.dao.inf.INhanVien;
import com.duykypaul.entity.NhanVien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements INhanVien{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Boolean kiemTraDangNhap(String email, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from NhanVien where email='" +email+"' and matkhau='" +matkhau+ "'";
		try {
			NhanVien nv = (NhanVien) session.createQuery(sql).getSingleResult();
			return nv != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean themNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Integer manhanvien = (Integer) session.save(nhanVien);
		return manhanvien > 0;
	}
	
}
