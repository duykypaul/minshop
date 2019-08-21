package com.duykypaul.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable {
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
