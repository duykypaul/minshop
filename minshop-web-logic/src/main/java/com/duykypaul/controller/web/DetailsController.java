package com.duykypaul.controller.web;

import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chi-tiet")
public class DetailsController {
	@Autowired
	ProductService productService;

	@GetMapping("/{product_id}")
	public String Default(@PathVariable Integer product_id, ModelMap modelMap) {
		Product product = productService.getProductById(product_id);
		modelMap.addAttribute("product", product);
		return "web/details";
	}
}
