package com.duykypaul.core.service;

import com.duykypaul.core.dao.InvoiceDetailsDao;
import com.duykypaul.core.inf.IInvoiceDetails;
import com.duykypaul.core.persistence.entity.InvoiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailsService implements IInvoiceDetails {
    @Autowired
    InvoiceDetailsDao invoiceDetailsDao;
    @Override
    public Boolean addInvoiceDetails(InvoiceDetails invoiceDetails) {
        return invoiceDetailsDao.addInvoiceDetails(invoiceDetails);
    }
}
