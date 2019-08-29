package com.duykypaul.controller;

import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.ProductLine;
import com.duykypaul.core.service.ProductLineService;
import com.duykypaul.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chitiet")
public class DetailsController {
	@Autowired
	ProductService productService;

    @Autowired
	ProductLineService productLineService;

	@GetMapping("/{product_id}")
	public String Default(@PathVariable Integer product_id, ModelMap modelMap) {
		Product product = productService.getProductById(product_id);
		List<ProductLine> productLineList = productLineService.getProductLineList();
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("productLineList", productLineList);
		return "details";
	}

}
