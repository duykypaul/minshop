package com.duykypaul.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duykypaul.dao.impl.NhanVienImpl;
import com.duykypaul.entity.NhanVien;

@Repository
public class NhanVienDao implements NhanVienImpl{
	@Autowired
	SessionFactory sessionFactory;

	@Override
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
	
}
