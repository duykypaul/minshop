package com.duykypaul.service;

import com.duykypaul.dao.ProductLineDao;
import com.duykypaul.dao.inf.IProductLine;
import com.duykypaul.entity.ProductLine;
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
