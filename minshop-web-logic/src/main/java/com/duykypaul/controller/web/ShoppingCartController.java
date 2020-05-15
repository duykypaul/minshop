package com.duykypaul.controller.web;

import com.duykypaul.core.persistence.entity.Invoice;
import com.duykypaul.core.persistence.entity.Invoice;
import com.duykypaul.core.persistence.entity.InvoiceDetails;
import com.duykypaul.core.persistence.entity.InvoiceDetailsId;
import com.duykypaul.core.persistence.entity.ShoppingCart;
import com.duykypaul.core.service.InvoiceDetailsService;
import com.duykypaul.core.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("gio-hang/")
@SessionAttributes({"shoppingCartList"})
public class ShoppingCartController {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceDetailsService invoiceDetailsService;

    @GetMapping
    public String Default() {
        return "web/shopping-cart";
    }

    @PostMapping
    public void addInvoice(@RequestParam String customer_name, @RequestParam String phone_number,
                             @RequestParam String delivery_address, @RequestParam String form_of_delivery,
                             @RequestParam String comment, HttpSession httpSession) {
        if (null != httpSession.getAttribute("shoppingCartList")) {
            List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
            Invoice invoice = new Invoice(customer_name, phone_number, delivery_address, form_of_delivery, comment);
            Integer invoiceId = invoiceService.addInvoice(invoice);
            if (invoiceId > 0) {
                for (ShoppingCart shoppingCart : shoppingCartList) {
                    InvoiceDetailsId invoiceDetailsId = new InvoiceDetailsId(invoice.getInvoice_id(), shoppingCart.getProduct_details_id());
                    InvoiceDetails invoiceDetails = new InvoiceDetails(invoiceDetailsId, shoppingCart.getQuantity(), shoppingCart.getPrice());
                    invoiceDetailsService.addInvoiceDetails(invoiceDetails);
                }
            } else {
                System.out.println("add invoice failed");
            }
        }
    }

}
