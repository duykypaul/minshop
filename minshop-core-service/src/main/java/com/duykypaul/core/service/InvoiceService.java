package com.duykypaul.core.service;

import com.duykypaul.core.dao.InvoiceDao;
import com.duykypaul.core.inf.IInvoice;
import com.duykypaul.core.persistence.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoice {
    @Autowired
    InvoiceDao invoiceDao;

    @Override
    public Integer addInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }
}
