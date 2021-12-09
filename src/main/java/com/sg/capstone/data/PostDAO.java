package com.sg.capstone.data;

import com.sg.capstone.model.Post;

import java.util.List;

public interface PostDAO {
    // Adds a post
    Post addPost(Post post);

    // Gets list of all posts
    List<Post> getAllPosts();

    // Gets posts by its id
    Post getPostById(int userId);

    // Edits a post
    Boolean editPost(int postId, Post post);

    // Deletes a user
    Boolean deletePost(int postId);
}
