package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IProduct;
import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Override
    @Transactional
    public List<Product> getProductListById(Integer product_line_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product where product_line_id = " + product_line_id;
        List<Product> productList = session.createQuery(sql).getResultList();
        return productList;
    }

    @Override
    @Transactional
    public Integer removeProductById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        Set<ProductDetails> productDetailsSet = product.getProductDetailsList();
        for (ProductDetails productDetails: productDetailsSet) {
            session.createQuery("delete from InvoiceDetails where product_details_id=" + productDetails.getProduct_details_id()).executeUpdate();
        }
        session.createQuery("delete from PromotionDetails where product_id=" + id).executeUpdate();
        session.createQuery("delete from ProductDetails where product_id=" + id).executeUpdate();
        return session.createQuery("delete from Product where product_id=" + id).executeUpdate();
//        session.delete(product);
    }

    @Override
    @Transactional
    public Integer saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(product);
    }
}
