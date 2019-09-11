package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IInvoiceDetails;
import com.duykypaul.core.persistence.entity.InvoiceDetails;
import com.duykypaul.core.persistence.entity.InvoiceDetailsId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InvoiceDetailsDao implements IInvoiceDetails {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Boolean addInvoiceDetails(InvoiceDetails invoiceDetails) {
        Session session = sessionFactory.getCurrentSession();
        InvoiceDetailsId id =  (InvoiceDetailsId) session.save(invoiceDetails);
        return id != null;
    }
}
