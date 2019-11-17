package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IProductColor;
import com.duykypaul.core.persistence.entity.ProductColor;
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
public class ProductColorDao implements IProductColor {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<ProductColor> getProductColorList() {
        Session session = sessionFactory.getCurrentSession();
        return (List<ProductColor>)session.createQuery("from ProductColor").getResultList();
    }
}
