package com.sg.capstone.service;

import com.sg.capstone.data.HashtagDAO;
import com.sg.capstone.data.PostDAO;
import com.sg.capstone.data.UserDAO;
import com.sg.capstone.model.Post;
import com.sg.capstone.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public boolean approvePostById(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post addPost(Post post, String[] tags) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editPost(Post post, String[] tags) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePostById(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
