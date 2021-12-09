package com.sg.capstone.data;

import com.sg.capstone.model.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class HashtagDAODatabase implements HashtagDAO {
    
    @Autowired
    private final JdbcTemplate template;

    public HashtagDAODatabase(JdbcTemplate template) {
        this.template = template;
    }

    public List<Hashtag> getAllHashtags() {
        return template.query("SELECT * FROM hashtags", new HashtagRowMapper());
    }

    public List<Hashtag> getAllUniqueHashtags() {
        return template.query("SELECT DISTINCT 0 AS PostId, Tag FROM hashtags", new HashtagRowMapper());
    }

    public List<Hashtag> getHashtagsByPostId(int postId) {
        return template.query("SELECT * FROM hashtags WHERE PostId = ?", new HashtagRowMapper(),postId);
    }

    public List<Hashtag> getHashtagListByTag(String tag) {
        return template.query("SELECT * FROM hashtags WHERE LOWER(Tag) = LOWER( ? )", new HashtagRowMapper(),tag);
    }
    
    @Override
    public boolean hashtagExists(Hashtag hashtag) {
        return template.query("SELECT * FROM hashtags WHERE PostId = ? AND LOWER(Tag) = LOWER( ? )",new HashtagRowMapper(), hashtag.getPostId(), hashtag.getTag()).size() > 0;
    }

    public boolean add(Hashtag hashtag) {
        try {
            if(hashtagExists(hashtag)) return false;
            return template.update("INSERT INTO hashtags (PostId,Tag) VALUES (?,?)", hashtag.getPostId(),hashtag.getTag()) > 0;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(Hashtag hashtag) {
        final String sql = "DELETE FROM hashtags WHERE PostId = ? AND Tag = ?;";
        return template.update(sql, hashtag.getPostId(), hashtag.getTag()) > 0;
    }
    
    private final class HashtagRowMapper implements RowMapper<Hashtag> {

        @Override
        public Hashtag mapRow(ResultSet rs, int i) throws SQLException {
            return new Hashtag(rs.getInt("PostId"),rs.getString("Tag"));
        }
        
    }
}
