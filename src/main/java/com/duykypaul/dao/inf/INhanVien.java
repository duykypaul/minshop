package com.duykypaul.dao.inf;

import com.duykypaul.entity.NhanVien;

public interface INhanVien {
	Boolean kiemTraDangNhap(String email, String matkhau);
	Boolean themNhanVien(NhanVien nhanVien);
}
