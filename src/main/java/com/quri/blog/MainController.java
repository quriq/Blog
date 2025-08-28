package com.quri.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


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

    @GetMapping("/blog/add")
    public String add(){
            return "add";}
    @PostMapping("/blog/add")
    public String postAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String text,
                          Model model) {
        Posts posts = new Posts(title,anons,text);
        postsRepo.save(posts);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String id(@PathVariable(value = "id") long id, Model model){
        if(!postsRepo.existsById(id)){
            return "/blog";
        }
        Optional<Posts> posts = postsRepo.findById(id);
        ArrayList<Posts> res = new ArrayList<>();
        posts.ifPresent(res::add);
        model.addAttribute("posts", res);
        return "id";

    }
}
