package com.duykypaul.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer masanpham;
    String tensanpham;
    String giatien;
    String mota;
    String hinhanhsanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="madanhmuc")
    DanhMucSanPham danhmucsanpham;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="masanpham")
    Set<ChiTietSanPham> chitietsanpham;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="chitietkhuyenmai",
    joinColumns = {@JoinColumn(name="masanpham", referencedColumnName="masanpham")},
    inverseJoinColumns = {@JoinColumn(name="makhuyenmai", referencedColumnName="makhuyenmai")})
    Set<KhuyenMai> danhsachkhuyenmai;

    public Integer getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(Integer masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public DanhMucSanPham getDanhmucsanpham() {
        return danhmucsanpham;
    }

    public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
        this.danhmucsanpham = danhmucsanpham;
    }

    public Set<ChiTietSanPham> getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }

    public Set<KhuyenMai> getDanhsachkhuyenmai() {
        return danhsachkhuyenmai;
    }

    public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
        this.danhsachkhuyenmai = danhsachkhuyenmai;
    }
}
