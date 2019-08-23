package com.duykypaul.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.duykypaul.entity.ChucVu;
import com.duykypaul.entity.NhanVien;
import com.duykypaul.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
@SessionAttributes("email")
public class DangNhapController {
	@Autowired
	NhanVienService nhanVienService;

	@GetMapping
	public String Default() {
		return "dangnhap";
	}

	@PostMapping
	public String signUp(@RequestParam String email, @RequestParam String matkhau, 
			@RequestParam String confirmPassword, ModelMap modelMap) {
		if(isValid(email)) {
			if (matkhau.equals(confirmPassword)) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setMatkhau(matkhau);
				nhanVien.setChucvu(new ChucVu(3, "USER"));
				Boolean checkSignUp = nhanVienService.themNhanVien(nhanVien);
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
