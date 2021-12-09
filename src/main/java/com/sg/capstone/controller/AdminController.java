package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import com.sg.capstone.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return null;
    }

    @GetMapping("/posts/unexpired")
    public List<Post> getAllUnexpiredPosts() {
        return null;
    }

    @GetMapping("/posts/expired")
    public List<Post> getAllExpiredPosts() {
        return null;
    }

    @PostMapping("/posts/{postId}")
    public Post getPostById() {
        return null;
    }

    @PostMapping("/addpost")
    public Post addPost() {
        return null;
    }

    @PostMapping("/editpost/{postId}")
    public Boolean editPost() {
        return null;
    }

    @DeleteMapping("/deletepost/{postId}")
    public Boolean deletePost() {
        return null;
    }

    @PostMapping("/approvepost/{postId}")
    public Boolean approvePost() {
        return null;
    }

    @PostMapping("/adduser")
    public User adduser() {
        return null;
    }
}
