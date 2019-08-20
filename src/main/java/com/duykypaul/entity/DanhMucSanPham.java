package com.duykypaul.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="danhmucsanpham")
public class DanhMucSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer madanhmuc;
    String tendanhmuc;
    String hinhanhdanhmuc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="madanhmuc")
    Set<SanPham> danhsachsanpham;

    public Set<SanPham> getDanhsachsanpham() {
        return danhsachsanpham;
    }

    public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
        this.danhsachsanpham = danhsachsanpham;
    }

    public Integer getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(Integer madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getHinhanhdanhmuc() {
        return hinhanhdanhmuc;
    }

    public void setHinhanhdanhmuc(String hinhanhdanhmuc) {
        this.hinhanhdanhmuc = hinhanhdanhmuc;
    }
}
