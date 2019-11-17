package com.duykypaul.core.service;

import com.duykypaul.core.dao.ProductSizeDao;
import com.duykypaul.core.inf.IProductSize;
import com.duykypaul.core.persistence.entity.ProductSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSizeService implements IProductSize {
    @Autowired
    ProductSizeDao productSizeDao;
    @Override
    public List<ProductSize> getProductSizeList() {
        return productSizeDao.getProductSizeList();
    }
}
