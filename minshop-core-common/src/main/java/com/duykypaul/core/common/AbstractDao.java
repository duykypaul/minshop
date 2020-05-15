package com.duykypaul.core.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    @Autowired
    SessionFactory sessionFactory;

    private Class<T> persistenceClass;

    public AbstractDao(){
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return this.persistenceClass.getSimpleName();
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<T> list;
        try{
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
        } catch (HibernateException e) {
            throw e;
        }
        return list;
    }
}
