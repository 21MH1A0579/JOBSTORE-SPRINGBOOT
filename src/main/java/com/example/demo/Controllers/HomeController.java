package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home() {
        return "home"; 
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login"; 
    }
    
    @GetMapping("/register")
    public String RegisterPage() {
        return "register"; 
    }
    

}
