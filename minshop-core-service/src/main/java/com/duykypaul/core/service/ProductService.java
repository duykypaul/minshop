package com.duykypaul.core.service;

import com.duykypaul.core.dao.ProductDao;
import com.duykypaul.core.inf.IProduct;
import com.duykypaul.core.persistence.entity.Product;
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

    @Override
    public List<Product> getProductListById(Integer id) {
        return productDao.getProductListById(id);
    }

    @Override
    public Integer removeProductById(Integer id) {
        return productDao.removeProductById(id);
    }
}
