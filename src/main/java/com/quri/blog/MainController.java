package com.quri.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
@Autowired
private PostsRepo postsRepo;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/blog")
    public String blog(Model model)
    {
        Iterable<Posts> posts = postsRepo.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
