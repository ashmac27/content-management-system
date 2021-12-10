package com.sg.capstone.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class HashtagDAODatabaseTest {
    
    @Autowired
    private HashtagDAO hashtagDAO;
    
    @Autowired
    private PostDAO postDAO;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Sql(scripts = {"file:Capstone_Schema.sql"})
    void getAllHashtags() {
    }

    @Test
    void getAllUniqueHashtags() {
    }

    @Test
    void getHashtagsByPostId() {
    }

    @Test
    void getHashtagListByTag() {
    }

    @Test
    void hashtagExists() {
    }

    @Test
    @Sql(scripts = {"file:Capstone_Schema.sql"})
    void add() {
        
    }

    @Test
    void delete() {
    }
}