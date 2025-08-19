package com.quri.blog;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {
@Autowired
private UsersRepo usersRepo;
    @GetMapping("/reg")
    public String getReg() {
        return "reg";}
    @PostMapping("/reg")
    public String regUser(Users user){
        usersRepo.save(user);
        return "/login";
    }


}
