package com.duykypaul.controller;

import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{product_line_id}")
    public String Default(@PathVariable Integer product_line_id, ModelMap modelMap) {
        List<Product> productList = productService.getProductListById(product_line_id);
        modelMap.addAttribute("productList", productList);
        return "product";
    }
}
