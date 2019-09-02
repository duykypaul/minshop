package com.duykypaul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("gio-hang/")
@SessionAttributes({"shoppingCartList"})
public class ShoppingCartController {
    @GetMapping
    public String Default() {
        return "shopping-cart";
    }
}
