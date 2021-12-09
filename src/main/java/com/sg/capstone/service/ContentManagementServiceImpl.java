package com.sg.capstone.service;

import com.sg.capstone.data.HashtagDAO;
import com.sg.capstone.data.PostDAO;
import com.sg.capstone.data.UserDAO;
import com.sg.capstone.model.Hashtag;
import com.sg.capstone.model.Post;
import com.sg.capstone.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentManagementServiceImpl implements ContentManagementService {

    @Autowired
    HashtagDAO hashtagDAO;

    @Autowired
    PostDAO postDAO;

    @Autowired
    UserDAO userDAO;

    @Override
    public List<Post> getAllPosts(boolean expired, boolean published, boolean approved, String[] tags) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post getPostById(int postId, boolean expired, boolean published, boolean approved, String[] tags) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Allows approval of a post
    @Override
    public boolean approvePostById(int postId) {
        Post post = postDAO.getPostById(postId);
        post.setApproved(true);
        return postDAO.editPost(postId, post);
    }

    // Adds a post to the system
    @Override
    public Post addPost(Post post, String[] tags) {
        Post addedPost = postDAO.addPost(post);
        for (String tag : tags) {
            Hashtag hashtag = new Hashtag();
            hashtag.setPostId(post.getPostId());
            hashtag.setTag(tag);
            hashtagDAO.add(hashtag);
        }
        return addedPost;
    }

    @Override
    public boolean editPost(Post post, String[] tags) {
        postDAO.getPostById(post.getPostId());
        for(String tag : tags){
            Hashtag ht = new Hashtag();
            ht.setPostId(post.getPostId());
            ht.setTag(tag);
            hashtagDAO.add(ht);
        }
        return postDAO.editPost(post.getPostId(), post);
    }

    @Override
    public boolean deletePostById(int postId) {
        return postDAO.deletePost(postId);
    }

    @Override
    public User addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
