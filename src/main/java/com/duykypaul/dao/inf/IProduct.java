package com.duykypaul.dao.inf;

import com.duykypaul.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> getProductListLimit(Integer startIndex);
}
