package com.duykypaul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sizesanpham")
public class SizeSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer masize;
    String size;

    public Integer getMasize() {
        return masize;
    }

    public void setMasize(Integer masize) {
        this.masize = masize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
