package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IInvoice;
import com.duykypaul.core.persistence.entity.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InvoiceDao implements IInvoice {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Integer addInvoice(Invoice invoice) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(invoice);
    }
}
