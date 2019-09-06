package com.duykypaul.core.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name="invoice_details")
public class InvoiceDetails {
    @EmbeddedId
    InvoiceDetailsId invoiceDetailsId;

    Integer quantity;
    String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
