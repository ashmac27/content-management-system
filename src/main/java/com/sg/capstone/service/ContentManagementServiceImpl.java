package com.sg.capstone.service;

import com.sg.capstone.data.HashtagDAO;
import com.sg.capstone.data.PostDAO;
import com.sg.capstone.data.UserDAO;
import com.sg.capstone.model.Hashtag;
import com.sg.capstone.model.Post;
import com.sg.capstone.model.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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
        List<Post> result;
        if(expired) result = postDAO.getUnexpiredPosts(LocalDateTime.now());
        else result = postDAO.getAllPosts();
        
        // Filters list by if they've been published and approved
        List<Post> tempResult = result.stream().filter(post -> {
            return (!published || post.getPublishDate()==null || post.getPublishDate().isBefore(LocalDateTime.now())) &&
                    (!approved || post.isApproved());
        }).collect(Collectors.toList());
        if(tags==null || tags.length==0) return tempResult;
        return tempResult.stream().filter(post -> {
            // Replace all hashtags with lowercase versions (for comparing)
            List<String> tagList = hashtagDAO.getHashtagsByPostId(post.getPostId()).stream().map(tag -> tag.getTag().toLowerCase()).collect(Collectors.toList());
            // If there ARE tags, filter by them
            for(String tag : tags) {
                // If tag exists, post is valid
                if(tagList.contains(tag.toLowerCase())) return true;
            }
            return false;
        }).toList();
    }

    @Override
    public Post getPostById(int postId, boolean expired, boolean published, boolean approved, String[] tags) {
        Post post = postDAO.getPostById(postId);
        // Post has expired, return nothing
        if(expired && post.getExpireDate()!=null && post.getExpireDate().isBefore(LocalDateTime.now())) return null;
        // Post has not been published, return nothing
        if(published && post.getPublishDate()!=null && post.getPublishDate().isAfter(LocalDateTime.now())) return null;
        // Post has not been approved, return nothing
        if(approved && !post.isApproved()) return null;
        
        // If there are no tags to filter by, return post
        if(tags==null || tags.length==0) return post;
        // Replace all hashtags with lowercase versions (for comparing)
        List<String> tagList = hashtagDAO.getHashtagsByPostId(postId).stream().map(tag -> tag.getTag().toLowerCase()).collect(Collectors.toList());
        // If there ARE tags, filter by them
        for(String tag : tags) {
            // If tag exists, post is valid
            if(tagList.contains(tag.toLowerCase())) return post;
        }
        // Found no posts with one of these tags, return null
        return null;
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
