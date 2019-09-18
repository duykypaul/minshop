package com.duykypaul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/home")
public class DashboardController {
    @GetMapping
    public String Default(){
        return "admin/dashboard";
    }
}
