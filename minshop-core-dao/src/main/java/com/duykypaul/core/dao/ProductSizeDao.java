package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IProductSize;
import com.duykypaul.core.persistence.entity.ProductSize;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductSizeDao implements IProductSize {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<ProductSize> getProductSizeList() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductSize";
        List<ProductSize> productSizes = (List<ProductSize>)session.createQuery(sql).getResultList();
        return productSizes;
    }
}
