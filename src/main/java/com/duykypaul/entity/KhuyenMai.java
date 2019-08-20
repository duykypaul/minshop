package com.duykypaul.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="khuyenmai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer makhuyenmai;
    String tenkhuyenmai;
    String thoigianbatdau;
    String thoigianketthuc;
    String mota;
    String hinhanhkhuyenmai;
    Integer giagiam;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="chitietkhuyenmai",
        joinColumns = {@JoinColumn(name="makhuyenmai", referencedColumnName="makhuyenmai")},
        inverseJoinColumns = {@JoinColumn(name="masanpham", referencedColumnName="masanpham")}
    )
    Set<SanPham> danhsachsanpham;

    public Integer getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(Integer makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public String getTenkhuyenmai() {
        return tenkhuyenmai;
    }

    public void setTenkhuyenmai(String tenkhuyenmai) {
        this.tenkhuyenmai = tenkhuyenmai;
    }

    public String getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(String thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanhkhuyenmai() {
        return hinhanhkhuyenmai;
    }

    public void setHinhanhkhuyenmai(String hinhanhkhuyenmai) {
        this.hinhanhkhuyenmai = hinhanhkhuyenmai;
    }

    public Integer getGiagiam() {
        return giagiam;
    }

    public void setGiagiam(Integer giagiam) {
        this.giagiam = giagiam;
    }

    public Set<SanPham> getDanhsachsanpham() {
        return danhsachsanpham;
    }

    public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
        this.danhsachsanpham = danhsachsanpham;
    }

}
