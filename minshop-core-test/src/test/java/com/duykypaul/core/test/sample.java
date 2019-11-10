package com.duykypaul.core.test;

import com.duykypaul.core.dao.ProductDao;
import com.duykypaul.core.persistence.entity.Product;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class sample {
    @Test
    public void getProductListByIdTest() {
        Integer product_line_id = 1;
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProductListById(product_line_id);
    }
}
