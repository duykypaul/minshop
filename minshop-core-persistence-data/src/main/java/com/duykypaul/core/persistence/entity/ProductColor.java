package com.duykypaul.core.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="product_color")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_color_id;
    String name;

    public Integer getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(Integer product_color_id) {
        this.product_color_id = product_color_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
