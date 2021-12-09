package com.sg.capstone.data;

import com.sg.capstone.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PostDAODatabase implements PostDAO {

    @Autowired
    private JdbcTemplate jdbc;

    // Adds a post
    @Override
    public Post addPost(Post post){
        final String ADD_POST = "INSERT INTO posts " +
                "(PostId, Title, Content, DateAdded, Approved, PublishDate, ExpireDate, UserId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(ADD_POST, post.getPostId(), post.getTitle(), post.getContent(), post.getDateAdded(), post.isApproved(), post.getPublishDate(), post.getExpireDate(), post.getUserId());
        return post;
    }

    // Gets list of all posts
    @Override
    public List<Post> getAllPosts(){
        final String SELECT_ALL_POSTS = "SELECT * " + "FROM posts";
        List<Post> allPosts = jdbc.query(SELECT_ALL_POSTS, new PostMapper() );
        return allPosts;
    }

    // Gets posts by its id
    @Override
    public Post getPostById(int postId){
        final String SELECT_POST = "SELECT * " +
                "FROM posts " +
                "WHERE postId = ?";
        Post post = jdbc.queryForObject(SELECT_POST, new PostMapper(), postId );
        return post;
    }

    // Edits a post
    @Override
    public Boolean editPost(int postId, Post post){
        final String UPDATE_POST = "UPDATE posts SET " +
                "Title = ?, " +
                "Content = ?, " +
                "DateAdded = ? " +
                "Approved = ?, " +
                "PublishDate = ?, " +
                "ExpireDate = ?, " +
                "UserId = ? " +
                "WHERE postId = ?";
        return jdbc.update(UPDATE_POST,
                post.getTitle(),
                post.getContent(),
                post.getDateAdded(),
                post.isApproved(),
                post.getPublishDate(),
                post.getExpireDate(),
                post.getUserId(),
                postId) >0;

    }

    // Deletes a post
    @Override
    public Boolean deletePost(int postId){
        final String DELETE_POST = "DELETE FROM posts " +
                "WHERE PostId = ?";
        return jdbc.update(DELETE_POST, postId) > 0;

    }

    public final static class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("PostId"));
            post.setTitle(rs.getString("Title"));
            post.setContent(rs.getString("Content"));
            post.setDateAdded(rs.getTimestamp("DateAdded").toLocalDateTime());
            post.setApproved(rs.getBoolean("Approved"));
            post.setPublishDate(rs.getTimestamp("PublishDate").toLocalDateTime());
            post.setExpireDate(rs.getTimestamp("ExpireDate").toLocalDateTime());
            post.setUserId(rs.getInt("UserId"));
            return post;
        }
    }
}
