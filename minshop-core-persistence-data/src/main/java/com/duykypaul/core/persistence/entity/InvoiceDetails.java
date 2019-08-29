package com.duykypaul.core.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name="invoice_details")
public class InvoiceDetails {
    @EmbeddedId
    InvoiceDetailsId invoiceDetailsId;

    Integer quantity;
    Integer price;
}
