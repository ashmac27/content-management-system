package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/posts")
    public List<Post> getAllValidPost() {
        return null;
    }

    @GetMapping("/posts/{postId}")
    public Post getValidPostById() {
        return null;
    }
}
