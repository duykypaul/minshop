package com.duykypaul.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhanvien")
public class NhanVien {
	@Id
	Integer idNhanVien;
	String tenNhanVien;
	Integer tuoi;
	
	public Integer getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(Integer idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Integer getTuoi() {
		return tuoi;
	}
	public void setTuoi(Integer tuoi) {
		this.tuoi = tuoi;
	}

	
}
