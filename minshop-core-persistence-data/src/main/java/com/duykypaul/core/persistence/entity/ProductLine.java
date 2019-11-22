package com.duykypaul.core.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="product_line")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_line_id;
    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product_line_id")
    Set<Product> productList;

    public Integer getProduct_line_id() {
        return product_line_id;
    }

    public void setProduct_line_id(Integer product_line_id) {
        this.product_line_id = product_line_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}
