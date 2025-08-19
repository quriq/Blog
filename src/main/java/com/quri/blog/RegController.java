package com.quri.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {
private UserService userService;
    @Autowired
    public RegController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String getReg(Model model) {
        model.addAttribute("user", new Users());
        return "reg";}
    @PostMapping("/reg")
    public String regUser(@ModelAttribute("user") Users user) {
            userService.registerNewUserAccount(user); // Используем UserService
            return "redirect:/login";
    }


}
