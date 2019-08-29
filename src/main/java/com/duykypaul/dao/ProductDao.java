package com.duykypaul.dao;

import com.duykypaul.dao.inf.IProduct;
import com.duykypaul.entity.Product;
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
public class ProductDao implements IProduct {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Product> getProductListLimit(Integer startIndex) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product";
        List<Product> productList = session.createQuery(sql).setFirstResult(startIndex).setMaxResults(15).getResultList();
        return productList;
    }

    @Override
    @Transactional
    public Product getProductById(Integer product_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product where product_id = " + product_id;
        Product product = (Product) session.createQuery(sql).getSingleResult();
        return product;
    }
}
