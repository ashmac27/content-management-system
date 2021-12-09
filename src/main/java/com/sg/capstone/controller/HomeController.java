package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller contains the different endpoints used by a regular user
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    // Gets all the valid posts
    @GetMapping("/posts")
    public List<Post> getAllValidPost() {
        return null;
    }

    // Gets a valid post by id
    @GetMapping("/posts/{postId}")
    public Post getValidPostById() {
        return null;
    }
}
