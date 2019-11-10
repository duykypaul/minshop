package com.duykypaul.controller.admin;

import com.duykypaul.core.common.constant.CoreConstant;
import com.duykypaul.core.persistence.entity.User;
import com.duykypaul.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.dom.core.CoreConstants;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String Default(ModelMap modelMap){
        List<User> userList = userService.getListUser();
        modelMap.addAttribute("userList", userList);
        return "admin/user";
    }
}
