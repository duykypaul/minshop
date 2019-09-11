package com.duykypaul.core.persistence.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InvoiceDetailsId implements Serializable {
    Integer invoice_id;
    Integer product_details_id;

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getProduct_details_id() {
        return product_details_id;
    }

    public void setProduct_details_id(Integer product_details_id) {
        this.product_details_id = product_details_id;
    }

    public InvoiceDetailsId(Integer invoice_id, Integer product_details_id) {
        this.invoice_id = invoice_id;
        this.product_details_id = product_details_id;
    }
}
