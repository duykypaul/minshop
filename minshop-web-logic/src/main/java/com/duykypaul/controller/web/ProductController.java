package com.duykypaul.controller.web;

import com.duykypaul.core.data.ProductSearchBean;
import com.duykypaul.core.persistence.entity.Product;
import com.duykypaul.core.persistence.entity.ProductColor;
import com.duykypaul.core.persistence.entity.ProductLine;
import com.duykypaul.core.persistence.entity.ProductSize;
import com.duykypaul.core.service.ProductColorService;
import com.duykypaul.core.service.ProductLineService;
import com.duykypaul.core.service.ProductService;
import com.duykypaul.core.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/san-pham", "/admin/product-line"})
@SessionAttributes({"product"})
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductLineService productLineService;
    @Autowired
    ProductColorService productColorService;
    @Autowired
    ProductSizeService productSizeService;

    @GetMapping("/{product_line_id}")
    public String Default(@PathVariable Integer product_line_id, ModelMap modelMap) {
        List<Product> productList = productService.getProductListById(product_line_id);
//        modelMap.addAttribute("productList", productList);
        System.out.println(productService.findAll().get(0));
        String url = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI();
        if(url.contains("/product-line")) return "admin/product";
        return "web/product";
    }

    @GetMapping("/search")
    public String productSearch (@ModelAttribute("productSearchBean") ProductSearchBean data, ModelMap modelMap) {
        Object[] result = productService.findProductListSearchInfo(data);
        List<Product> productList = (List<Product>) result[0];
        modelMap.addAttribute("productList", productList);
        modelMap.addAttribute("ProductSearchBean", data);
        modelMap.addAttribute("totalPage", Math.ceil((Integer)result[1] / data.getMaxResult()) + 1);
        modelMap.addAttribute("pageNumber", data.getPageNumber());
        return "admin/product";
    }

    @GetMapping("/insert-product")
    public String Insert(ModelMap modelMap, HttpSession httpSession) {
        List<ProductColor> productColorList = productColorService.getProductColorList();
        List<ProductSize> productSizeList = productSizeService.getProductSizeList();
        List<ProductLine> productLineList = productLineService.getProductLineList();
        modelMap.addAttribute("productColorList", productColorList);
        modelMap.addAttribute("productSizeList", productSizeList);
        modelMap.addAttribute("productLineList", productLineList);
        return "admin/insertProduct";
    }
}
