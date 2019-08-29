package com.duykypaul.service;

import com.duykypaul.dao.ProductDao;
import com.duykypaul.dao.inf.IProduct;
import com.duykypaul.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getProductListLimit(Integer startIndex) {
        return productDao.getProductListLimit(startIndex);
    }

    @Override
    public Product getProductById(Integer product_id) {
        return productDao.getProductById(product_id);
    }
}
