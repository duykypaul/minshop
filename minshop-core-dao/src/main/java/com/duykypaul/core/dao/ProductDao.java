package com.duykypaul.core.dao;

import com.duykypaul.core.common.AbstractDao;
import com.duykypaul.core.data.ProductSearchBean;
import com.duykypaul.core.inf.IProduct;
import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.ProductDetails;
import com.duykypaul.core.persistence.entity.PromotionDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ProductDao extends AbstractDao<Integer, Product> implements IProduct {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getProductListLimit(Integer startIndex) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product";
        List<Product> productList = session.createQuery(sql).setFirstResult(startIndex).setMaxResults(15).getResultList();
        return productList;
    }

    @Override
    public Product getProductById(Integer product_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product where product_id = " + product_id;
        Product product = (Product) session.createQuery(sql).getSingleResult();
        return product;
    }

    @Override
    public List<Product> getProductListById(Integer product_line_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product where product_line_id = " + product_line_id;
        List<Product> productList = session.createQuery(sql).getResultList();
        return productList;
    }

    @Override
    public Object[] findProductListSearchInfo(ProductSearchBean productSearchBean) {
        Session session = sessionFactory.getCurrentSession();
        Boolean priceToCheck = productSearchBean.getPriceTo() == null;
        Boolean priceFromCheck = productSearchBean.getPriceFrom() == null;
        StringBuilder sql = new StringBuilder("FROM ");
        sql.append("Product ");
        sql.append("where product_line_id = 1 ");
        sql.append("and LOWER(name) LIKE :nameProduct ");
        if(!priceFromCheck && priceToCheck) {
            sql.append("and price >= :priceFrom ");
        } else if(!priceFromCheck) {
            sql.append("and price between :priceFrom and :priceTo ");
        } else if(priceFromCheck && !priceToCheck) {
            sql.append("and price <= :priceTo");
        }
        Query query = session.createQuery(sql.toString());
        query.setString("nameProduct", "%" + productSearchBean.getNameProduct() + "%");
        if(!priceFromCheck) {
            query.setParameter("priceFrom", productSearchBean.getPriceFrom());
        }
        if(!priceToCheck) {
            query.setParameter("priceTo", productSearchBean.getPriceTo());
        }
        if(productSearchBean.getPageNumber() == null){
            productSearchBean.setPageNumber(1);
        }
        if(productSearchBean.getMaxResult() == null){
            productSearchBean.setMaxResult(5);
        }
        Integer offset = (productSearchBean.getPageNumber() - 1) * productSearchBean.getMaxResult();
        Integer totalPage = query.list().size();
        List<Product> productList = query.setFirstResult(offset).setMaxResults(productSearchBean.getMaxResult()).list();
        return new Object[]{productList, totalPage};
    }

    @Override
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
    public Integer saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(product);
    }

    @Override
    public Integer updateProduct(Product product) {
        Session session =  sessionFactory.getCurrentSession();
        session.update(product);
        return 1;
    }

    @Override
    public Boolean updatePriceProduct(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        product.setPrice(200000);
        session.update(product);
        return true;
    }

    public Integer savePromotionDetails(PromotionDetails promotionDetailsId){
        Session session = sessionFactory.getCurrentSession();
        session.save(promotionDetailsId);
        return 1;
    }
}
