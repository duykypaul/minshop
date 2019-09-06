package com.duykypaul.core.persistence.entity;

public class ShoppingCart {
    Integer product_id;
    String product_name;
    Integer product_color_id;
    String color_name;
    Integer product_size_id;
    String size_name;
    Integer price;
    Integer quantity;
    String image;
    Integer product_details_id;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(Integer product_color_id) {
        this.product_color_id = product_color_id;
    }

    public Integer getProduct_size_id() {
        return product_size_id;
    }

    public void setProduct_size_id(Integer product_size_id) {
        this.product_size_id = product_size_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getSize_name() {
        return size_name;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getProduct_details_id() {
        return product_details_id;
    }

    public void setProduct_details_id(Integer product_details_id) {
        this.product_details_id = product_details_id;
    }

    public ShoppingCart(Integer product_id, String product_name, Integer product_color_id, String color_name,
                        Integer product_size_id, String size_name, Integer price, Integer quantity, String image, Integer product_details_id ) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_color_id = product_color_id;
        this.color_name = color_name;
        this.product_size_id = product_size_id;
        this.size_name = size_name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.product_details_id = product_details_id;
    }

}
