package com.duykypaul.controller;

import com.duykypaul.entity.Product;
import com.duykypaul.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("email")
public class HomeController {
	@Autowired
	ProductService productService;

	@GetMapping
	public String Default(ModelMap modelMap) {
		List<Product> productList = productService.getProductListLimit(0);
		productList.forEach(item -> System.out.println(item));
		modelMap.addAttribute("productList", productList);
		return "home";
	}
	
}