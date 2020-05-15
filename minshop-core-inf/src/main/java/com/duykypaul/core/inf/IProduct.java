package com.duykypaul.core.inf;

import com.duykypaul.core.common.GenericDao;
import com.duykypaul.core.data.ProductSearchBean;
import com.duykypaul.core.persistence.entity.Product;

import java.util.List;

public interface IProduct extends GenericDao<Integer, Product> {
    List<Product> getProductListLimit(Integer startIndex);
    Product getProductById(Integer product_id);
    List<Product> getProductListById(Integer id);
    Object[] findProductListSearchInfo(ProductSearchBean productSearchBean);
    Integer removeProductById(Integer id);
    Integer saveProduct(Product product);
    Integer updateProduct(Product product);
    Boolean updatePriceProduct(Integer id);
}
