package com.duykypaul.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_id;
    String name;
    String price;
    String descriptions;
    String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_line_id")
    ProductLine productLine;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    Set<ProductDetails> productDetailsList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="promotion_details",
    joinColumns = {@JoinColumn(name="product_id", referencedColumnName="product_id")},
    inverseJoinColumns = {@JoinColumn(name="promotion_id", referencedColumnName="promotion_id")})
    Set<Promotion> promotionList;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Set<ProductDetails> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(Set<ProductDetails> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }

    public Set<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(Set<Promotion> promotionList) {
        this.promotionList = promotionList;
    }


}
