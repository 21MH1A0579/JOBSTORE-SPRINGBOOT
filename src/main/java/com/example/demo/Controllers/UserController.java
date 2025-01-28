package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Models.UserData;
import com.example.demo.Repositorys.UserDataRepo;
import com.example.demo.Services.LoggedDataService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDataRepo repo;
    @Autowired
    LoggedDataService userservice;
    
    @Autowired
    PasswordEncoder encoder;
     
    @PostMapping("/register")
    public String insertLoginData(@ModelAttribute UserData data) {
        data.setPassword(encoder.encode(data.getPassword()));
        repo.save(data);
        return "redirect:/login";
    }
    
    @GetMapping("/homepage")
    public String showDashboard(Model model) {
        UserData userData = userservice.getLoggedInUser();
        if (userData != null) {
            model.addAttribute("userData", userData);
        }
        return "homepage"; 
    }
    
   
    @GetMapping("/displayall")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseBody
    public List<UserData> disp() {
        return repo.findAll();
    }

    @GetMapping("/display/{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ResponseBody
    public Optional<UserData> dispuser(@PathVariable("id") String id) {
        return repo.findById(id);
    }
}
