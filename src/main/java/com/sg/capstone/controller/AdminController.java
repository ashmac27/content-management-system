package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import com.sg.capstone.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller contains the different endpoints used by an admin
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

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

    // Adds a post to the system
    @PostMapping("/addpost")
    public Post addPost() {
        return null;
    }

    // Edits a post from the system using the post id
    @PostMapping("/editpost/{postId}")
    public Boolean editPost() {
        return null;
    }

    // Deletes a post from the system using the post id
    @DeleteMapping("/editpost/{postId}")
    public Boolean deletePost() {
        return null;
    }

    // Approve an unapproved post using its id
    @PostMapping("/approvepost/{postId}")
    public Boolean approvePost() {
        return null;
    }

    // Adds a user to the system
    @PostMapping("/adduser")
    public User adduser() {
        return null;
    }
}
