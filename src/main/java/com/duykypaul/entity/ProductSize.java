package com.duykypaul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_size_id;
    String size;

    public Integer getProduct_size_id() {
        return product_size_id;
    }

    public void setProduct_size_id(Integer product_size_id) {
        this.product_size_id = product_size_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
