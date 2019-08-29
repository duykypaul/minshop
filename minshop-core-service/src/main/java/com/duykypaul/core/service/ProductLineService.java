package com.duykypaul.core.service;

import com.duykypaul.core.dao.ProductLineDao;
import com.duykypaul.core.inf.IProductLine;
import com.duykypaul.core.persistence.entity.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService implements IProductLine {
    @Autowired
    ProductLineDao productLineDao;

    @Override
    public List<ProductLine> getProductLineList() {
        return productLineDao.getProductLineList();
    }
}
