package com.duykypaul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idNhanVien;
	String tenNhanVien;
	Integer tuoi;
	
	public NhanVien(String tenNhanVien2, Integer tuoi2) {
		// TODO Auto-generated constructor stub
		this.tenNhanVien = tenNhanVien2;
		this.tuoi = tuoi2;
	}
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
