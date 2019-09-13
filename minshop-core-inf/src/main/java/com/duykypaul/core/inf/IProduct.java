package com.duykypaul.core.inf;

import com.duykypaul.core.persistence.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> getProductListLimit(Integer startIndex);
    Product getProductById(Integer product_id);
    List<Product> getProductListById(Integer id);
}
