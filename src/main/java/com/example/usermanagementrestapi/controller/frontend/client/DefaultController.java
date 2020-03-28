package com.example.usermanagementrestapi.controller.frontend.client;

import com.example.usermanagementrestapi.model.request.view_model.ProductViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DefaultController {

    @GetMapping("/register")
    public String register() {

        return "register";

    }

    @GetMapping("/login")
    public String login(@ModelAttribute("productname") ProductViewModel productName) {

        return "login-register";
    }

    @GetMapping("/order")
    public String order(@ModelAttribute("productname") ProductViewModel productName) {

        return "checkout";
    }

}
