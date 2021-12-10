package com.sg.capstone.controller;

import com.sg.capstone.model.Post;
import com.sg.capstone.service.ContentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.sg.capstone.service.ContentManagementService;

/**
 * This controller contains the different endpoints used by a regular user
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ContentManagementService service;

    // Gets all the valid posts
    @GetMapping("/posts")
    public List<Post> getAllValidPost() {
        return service.getAllPosts(false, true, true, null);
    }

    // Gets a valid post by id
    @GetMapping("/posts/{postId}")
    public Post getValidPostById(@PathVariable int postId) {
        return service.getPostById(postId, false, true, true, null);
    }
}
