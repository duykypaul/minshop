package com.duykypaul.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId {
    Integer mahoadon;
    Integer machitietsanpham;

    public Integer getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Integer mahoadon) {
        this.mahoadon = mahoadon;
    }

    public Integer getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(Integer machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }
}
