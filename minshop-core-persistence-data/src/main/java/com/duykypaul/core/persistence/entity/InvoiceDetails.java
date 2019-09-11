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

    public InvoiceDetailsId getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(InvoiceDetailsId invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public InvoiceDetails(InvoiceDetailsId invoiceDetailsId, Integer quantity, Integer price) {
        this.invoiceDetailsId = invoiceDetailsId;
        this.quantity = quantity;
        this.price = price;
    }
}
