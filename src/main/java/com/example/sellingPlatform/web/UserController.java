package com.example.sellingPlatform.web;

import com.example.sellingPlatform.model.UserAuthorities;
import com.example.sellingPlatform.service.ProductService;
import com.example.sellingPlatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;
    private final ProductService productService;

    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @GetMapping("/register")
    public String register(){
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String registerName,
                           @RequestParam String registerEmail,
                           @RequestParam String registerPassword){
        userService.createUser(registerName,registerEmail,registerPassword, UserAuthorities.USER);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String getProductPage(Model model){
        model.addAttribute("bodyContent", "products");
        model.addAttribute("products", productService.listAll());
        return "master-template";
    }
}
