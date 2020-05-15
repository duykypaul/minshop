package com.duykypaul.core.service;

import com.duykypaul.core.dao.ProductDao;
import com.duykypaul.core.data.ProductSearchBean;
import com.duykypaul.core.inf.IProduct;
import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.PromotionDetails;
import com.duykypaul.core.persistence.entity.PromotionDetailsId;
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
    public Object[] findProductListSearchInfo(ProductSearchBean productSearchBean) {
        return productDao.findProductListSearchInfo(productSearchBean);
    }

    @Override
    public Integer removeProductById(Integer id) {
        return productDao.removeProductById(id);
    }

    @Override
    public Integer saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    public Integer updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Boolean updatePriceProduct(Integer id) {
        return productDao.updatePriceProduct(id);
    }

    public Integer savePromotionDetails(PromotionDetails promotionDetailsId){
        return productDao.savePromotionDetails(promotionDetailsId);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
