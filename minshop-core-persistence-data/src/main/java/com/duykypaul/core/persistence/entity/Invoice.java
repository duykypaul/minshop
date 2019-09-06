package com.duykypaul.core.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer invoice_id;
    String customer_name;
    String phone_number;
    String delivery_address;
    Boolean status;
    String invoice_creation_date;
    String form_of_delivery;
    String comment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    Set<InvoiceDetails> invoiceDetailsList;

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInvoice_creation_date() {
        return invoice_creation_date;
    }

    public void setInvoice_creation_date(String invoice_creation_date) {
        this.invoice_creation_date = invoice_creation_date;
    }

    public Set<InvoiceDetails> getInvoiceDetailsList() {
        return invoiceDetailsList;
    }

    public void setInvoiceDetailsList(Set<InvoiceDetails> invoiceDetailsList) {
        this.invoiceDetailsList = invoiceDetailsList;
    }

    public String getForm_of_delivery() {
        return form_of_delivery;
    }

    public void setForm_of_delivery(String form_of_delivery) {
        this.form_of_delivery = form_of_delivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Invoice(String customer_name, String phone_number, String delivery_address, String form_of_delivery, String comment) {
        this.customer_name = customer_name;
        this.phone_number = phone_number;
        this.delivery_address = delivery_address;
        this.form_of_delivery = form_of_delivery;
        this.comment = comment;
    }

    public Invoice() {
    }
}
