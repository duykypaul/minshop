package com.duykypaul.entity;

import javax.persistence.*;

@Entity @Table(name="product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_details_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_size_id")
    ProductSize productSize;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_color_id")
    ProductColor productColor;

    Integer quantity;
    String import_date;

    public Integer getProduct_details_id() {
        return product_details_id;
    }

    public void setProduct_details_id(Integer product_details_id) {
        this.product_details_id = product_details_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImport_date() {
        return import_date;
    }

    public void setImport_date(String import_date) {
        this.import_date = import_date;
    }
}
