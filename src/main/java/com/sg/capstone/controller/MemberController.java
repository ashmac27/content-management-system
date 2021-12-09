package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

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
    public Post addPostWithPendingApproval() {
        return null;
    }
}