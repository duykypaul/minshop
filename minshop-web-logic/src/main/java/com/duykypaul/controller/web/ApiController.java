package com.duykypaul.controller.web;

import com.duykypaul.core.persistence.entity.*;
import com.duykypaul.core.service.ProductService;
import com.duykypaul.core.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email", "shoppingCartList"})
public class ApiController {
	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
    ServletContext servletContext;
	@GetMapping("CheckLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		Boolean check = userService.checkLogin(email, password);
		if(check) {
			modelMap.addAttribute("email", email);
		}
		return "" + check;
	}

	@GetMapping("AddToCart")
    @ResponseBody
	public String addToCart(@RequestParam Integer product_id, @RequestParam String product_name,
						    @RequestParam Integer product_color_id, @RequestParam String color_name,
						    @RequestParam Integer product_size_id, @RequestParam String size_name,
						    @RequestParam Integer price, @RequestParam Integer quantity,
                            @RequestParam String image, @RequestParam Integer product_details_id,
                            HttpSession httpSession) {
		ShoppingCart shoppingCart = new ShoppingCart(product_id, product_name, product_color_id, color_name,
				product_size_id, size_name, price, 1, image, product_details_id);
		if(null == httpSession.getAttribute("shoppingCartList")){
			List<ShoppingCart> shoppingCartList = new ArrayList<>();
			shoppingCartList.add(shoppingCart);
			httpSession.setAttribute("shoppingCartList", shoppingCartList);
			return ((List<ShoppingCart>) httpSession.getAttribute("shoppingCartList")).size() + "";
		} else {
			List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
			Integer index = indexOfProductInShoppingCartList(httpSession, product_id, product_color_id, product_size_id);
			if(index != -1) {
				shoppingCartList.get(index).setQuantity(shoppingCartList.get(index).getQuantity() + 1);
			} else {
				shoppingCartList.add(shoppingCart);
			}
			return shoppingCartList.size() + "";
		}
	}

	private Integer indexOfProductInShoppingCartList(HttpSession httpSession, Integer product_id,
													 Integer product_color_id, Integer product_size_id) {
		List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
		for (Integer i = 0; i < shoppingCartList.size(); i++){
			Boolean check_product_id = shoppingCartList.get(i).getProduct_id() == product_id;
			Boolean check_product_color_id = shoppingCartList.get(i).getProduct_color_id() == product_color_id;
			Boolean check_product_size_id = shoppingCartList.get(i).getProduct_size_id() == product_size_id;

			if(check_product_id && check_product_color_id && check_product_size_id) {
				return i;
			}
		}
		return -1;
	}

	/*@GetMapping("GetSizeOfShoppingCart")
	@ResponseBody
	public String getSizeOfShoppingCart (HttpSession httpSession) {
		if (null != httpSession.getAttribute("shoppingCartList")) {
			List<ShoppingCart> shoppingCartList= (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
			return shoppingCartList.size() + "";
		}
		return "";
	}*/

	@GetMapping("UpdateShoppingCartList")
	@ResponseBody
	public void updateShoppingCartList(HttpSession httpSession, @RequestParam Integer product_id,
									   @RequestParam Integer product_color_id, @RequestParam Integer product_size_id,
									   @RequestParam Integer quantity) {
		if(null != httpSession.getAttribute("shoppingCartList")){
			List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
			Integer index = indexOfProductInShoppingCartList(httpSession, product_id, product_color_id, product_size_id);
			shoppingCartList.get(index).setQuantity(quantity);
		}
	}

	@GetMapping("RemoveProduct")
	@ResponseBody
	public String removeProduct(HttpSession httpSession, @RequestParam Integer product_id,
									   @RequestParam Integer product_color_id, @RequestParam Integer product_size_id) {
		List<ShoppingCart> shoppingCartList = new ArrayList<>();
		if(null != httpSession.getAttribute("shoppingCartList")){
			shoppingCartList = (List<ShoppingCart>) httpSession.getAttribute("shoppingCartList");
			Integer index = indexOfProductInShoppingCartList(httpSession, product_id, product_color_id, product_size_id);
			shoppingCartList.remove(index.intValue());
		}
		return shoppingCartList.size() + "";
	}

	@GetMapping("RemoveProducts")
	public String removeProducts(HttpSession httpSession, @RequestParam Integer id) {
		return productService.removeProductById(id).toString();
	}
	@GetMapping("RemoveUser")
	public void removeUsers(HttpSession httpSession, @RequestParam Integer id) {
		userService.removeUserById(id);
	}

	@PostMapping("UploadFile")
    @ResponseBody
    public String UploadFile(MultipartHttpServletRequest multipartHttpServletRequest) {
	    String path_save_file = servletContext.getRealPath("/resources/image/products/");
		Iterator<String> listNames = multipartHttpServletRequest.getFileNames();
		System.out.println(path_save_file);
		MultipartFile multipartFile = multipartHttpServletRequest.getFile(listNames.next());
        File file_save = new File(path_save_file + multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(file_save);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "true";
    }

	@PostMapping("SaveProduct")
	@ResponseBody
	public void saveProduct(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
            Product product = new Product();

            product.setName(jsonObject.get("name").asText());
            product.setPrice(jsonObject.get("price").asInt());
            product.setDescriptions(jsonObject.get("descriptions").asText());
            product.setImage(jsonObject.get("image").asText());
            product.setObject(jsonObject.get("object").asText());

            ProductLine productLine = new ProductLine();
            productLine.setProduct_line_id(jsonObject.get("product_line_id").asInt());
			product.setProductLine(productLine);
            JsonNode jsonProductDetails = jsonObject.get("productDetails");
            Set<ProductDetails> productDetailsList = new HashSet<>();
            for (JsonNode objectProductDetails : jsonProductDetails) {
                ProductDetails productDetails = new ProductDetails();

                ProductSize productSize =  new ProductSize();
                productSize.setProduct_size_id(objectProductDetails.get("product_size_id").asInt());

                ProductColor productColor = new ProductColor();
                productColor.setProduct_color_id(objectProductDetails.get("product_color_id").asInt());

                productDetails.setProductSize(productSize);
                productDetails.setProductColor(productColor);
                productDetails.setQuantity(objectProductDetails.get("quantity").asInt());

                productDetailsList.add(productDetails);
            }

            product.setProductDetailsList(productDetailsList);

            productService.saveProduct(product);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
