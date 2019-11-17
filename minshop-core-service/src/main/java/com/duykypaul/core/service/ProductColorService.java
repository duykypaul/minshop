package com.duykypaul.core.service;

import com.duykypaul.core.dao.ProductColorDao;
import com.duykypaul.core.inf.IProductColor;
import com.duykypaul.core.persistence.entity.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AssociationOverride;
import java.util.List;
@Service
public class ProductColorService implements IProductColor {
    @Autowired
    ProductColorDao productColorDao;
    @Override
    public List<ProductColor> getProductColorList() {
        return productColorDao.getProductColorList();
    }
}
