package com.duykypaul.controller.web;

import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.ProductLine;
import com.duykypaul.core.service.ProductLineService;
import com.duykypaul.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"email", "productLineList"})
public class HomeController {
	@Autowired
	ProductService productService;

	@Autowired
	ProductLineService productLineService;

	@GetMapping
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		List<Product> productList = productService.getProductListLimit(0);
		List<ProductLine> productLineList = productLineService.getProductLineList();
		modelMap.addAttribute("productList", productList);
		httpSession.setAttribute("productLineList", productLineList);
		return "web/home";
	}
	
}
