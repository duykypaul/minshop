package com.duykypaul.entity;

import javax.persistence.*;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer machitietsanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="masanpham")
    SanPham sanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="masize")
    SizeSanPham sizesanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mamau")
    MauSanPham mausanpham;

    Integer soluong;

    String ngaynhap;

    public Integer getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(Integer machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public SizeSanPham getSizesanpham() {
        return sizesanpham;
    }

    public void setSizesanpham(SizeSanPham sizesanpham) {
        this.sizesanpham = sizesanpham;
    }

    public MauSanPham getMausanpham() {
        return mausanpham;
    }

    public void setMausanpham(MauSanPham mausanpham) {
        this.mausanpham = mausanpham;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
}
