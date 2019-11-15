package com.duykypaul.controller.web;

import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/san-pham", "/admin/product-line"})
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{product_line_id}")
    public String Default(@PathVariable Integer product_line_id, ModelMap modelMap) {
        List<Product> productList = productService.getProductListById(product_line_id);
        modelMap.addAttribute("productList", productList);
        String url = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI();
        if(url.contains("/product-line")) return "admin/product";
        return "web/product";
    }

    @GetMapping("/insert-product")
    public String Insert() {
        return "admin/insertProduct";
    }
}
