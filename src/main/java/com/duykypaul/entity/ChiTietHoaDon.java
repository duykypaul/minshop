package com.duykypaul.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="chitiethoadon")
public class ChiTietHoaDon {
    @EmbeddedId
    ChiTietHoaDonId chiTietHoaDonId;

    Integer soluong;
    Integer giatien;
}
