package com.duykypaul.core.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer promotion_id;
    String name;
    String start_time;
    String end_time;
    String descriptions;
    String image;
    Integer current_price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="promotion_details",
        joinColumns = {@JoinColumn(name="promotion_id", referencedColumnName="promotion_id")},
        inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName="product_id")}
    )
    Set<Product> productList;

    public Integer getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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

    public Integer getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Integer current_price) {
        this.current_price = current_price;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}
