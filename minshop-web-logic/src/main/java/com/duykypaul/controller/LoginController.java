package com.duykypaul.controller;

import java.util.regex.Pattern;

import com.duykypaul.core.persistence.entity.Role;
import com.duykypaul.core.persistence.entity.User;
import com.duykypaul.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("dangnhap/")
@SessionAttributes("email")
public class LoginController {
	@Autowired
	UserService userService;

	@GetMapping
	public String Default() {
		return "login";
	}

	@PostMapping
	public String signUp(@RequestParam String email, @RequestParam String password,
			@RequestParam String confirmPassword, ModelMap modelMap) {
		if(isValid(email)) {
			if (password.equals(confirmPassword)) {
				User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(new Role(3, "USER"));
				Boolean checkSignUp = userService.addUser(user);
				if(checkSignUp) {
					modelMap.addAttribute("status_login", "Tạo tài khoản thành công! ");
				} else {
					modelMap.addAttribute("status_login", "Tạo tài khoản thất bại! ");
				}
			} else {
				modelMap.addAttribute("status_login", "Xác nhận lại mật khẩu! ");
			}
		} else {
			modelMap.addAttribute("status_login", "Email không hợp lệ! ");
		}
		return null;

	}

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
