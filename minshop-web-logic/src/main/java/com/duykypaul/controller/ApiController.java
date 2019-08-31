package com.duykypaul.controller;

import com.duykypaul.core.persistence.entity.ShoppingCart;
import com.duykypaul.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email", "shoppingCartList"})
public class ApiController {
	@Autowired
	UserService userService;

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
						  @RequestParam Integer price, @RequestParam Integer quantity, HttpSession httpSession) {
		ShoppingCart shoppingCart = new ShoppingCart(product_id, product_name, product_color_id, color_name,
				product_size_id, size_name, price, 1);
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
}
