package com.duykypaul.controller;

import com.duykypaul.core.persistence.entity.Invoice;
import com.duykypaul.core.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("gio-hang/")
@SessionAttributes({"shoppingCartList"})
public class ShoppingCartController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public String Default() {
        return "shopping-cart";
    }

    @PostMapping
    public String addInvoice(@RequestParam String customer_name, @RequestParam String phone_number,
                             @RequestParam String delivery_address, @RequestParam String form_of_delivery,
                             @RequestParam String comment) {
        Invoice invoice = new Invoice(customer_name, phone_number, delivery_address, form_of_delivery, comment);
        invoiceService.addInvoice(invoice);
        return "";
    }
}
