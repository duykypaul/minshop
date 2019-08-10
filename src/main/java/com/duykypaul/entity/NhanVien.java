package com.duykypaul.entity;

public class NhanVien {
	String tenNhanVien;
	String diaChi;
	int tuoi;
	GiamDoc doc;
	

	public GiamDoc getDoc() {
		return doc;
	}


	public void setDoc(GiamDoc doc) {
		this.doc = doc;
	}


	public String getTenNhanVien() {
		return tenNhanVien;
	}


	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public NhanVien(GiamDoc doc) {
		this.doc = doc;
	}
	
	
	public NhanVien() {
		
	}
	
	public NhanVien(String tenNhanVien, int tuoi) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.tuoi = tuoi;
	}
	
	
	public NhanVien(String tenNhanVien, String diaChi, int tuoi) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
	}


	public void getThongBao() {
		System.out.println(tenNhanVien + " " + tuoi);
	}
}
