package com.duykypaul.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"productLineList"})
@RequestMapping("/admin/home")
public class DashboardController {
    @GetMapping
    public String Default(){
        return "admin/dashboard";
    }
}
