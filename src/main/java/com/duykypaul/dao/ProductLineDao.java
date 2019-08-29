package com.duykypaul.dao;

import com.duykypaul.dao.inf.IProductLine;
import com.duykypaul.entity.ProductLine;
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
public class ProductLineDao implements IProductLine {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<ProductLine> getProductLineList() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductLine";
        List<ProductLine> productLineList = session.createQuery(sql).getResultList();
        return productLineList;
    }
}
