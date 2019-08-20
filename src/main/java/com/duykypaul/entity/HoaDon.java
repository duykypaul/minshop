package com.duykypaul.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer mahoadon;
    String tenkhachhang;
    String sdt;
    String diachigiaohang;
    Boolean tinhtrang;
    String ngaylap;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mahoadon")
    Set<ChiTietHoaDon> danhsachchitiethoadon;

    public Integer getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Integer mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public Set<ChiTietHoaDon> getDanhsachchitiethoadon() {
        return danhsachchitiethoadon;
    }

    public void setDanhsachchitiethoadon(Set<ChiTietHoaDon> danhsachchitiethoadon) {
        this.danhsachchitiethoadon = danhsachchitiethoadon;
    }
}
