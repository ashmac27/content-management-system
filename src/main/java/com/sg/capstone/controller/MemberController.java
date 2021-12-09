package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller contains the different endpoints used by a member of the blog
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    // Gets all the posts from the system
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return null;
    }

    // Gets all the unexpired posts from the system
    @GetMapping("/posts/unexpired")
    public List<Post> getAllUnexpiredPosts() {
        return null;
    }

    // Gets all expired posts from the system
    @GetMapping("/posts/expired")
    public List<Post> getAllExpiredPosts() {
        return null;
    }

    // Gets a posts from the system by id
    @PostMapping("/posts/{postId}")
    public Post getPostById() {
        return null;
    }

    // Adds a post to the system, but needs approval
    @PostMapping("/addpost")
    public Post addPostWithPendingApproval() {
        return null;
    }
}