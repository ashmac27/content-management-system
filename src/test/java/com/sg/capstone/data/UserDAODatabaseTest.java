package com.sg.capstone.data;

import com.sg.capstone.TestApplicationConfiguration;
import com.sg.capstone.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.jdbc.Sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class UserDAODatabaseTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @Sql(scripts = {"Capstone_Schema.sql"})
    public void getAllUsers() {
        // Arrange
        User

        // Act


        //Assert
    }

    @Test
    @Sql(scripts = {"Capstone_Schema.sql"})
    public void getUserById() {
        // Arrange


        // Act


        //Assert
    }

    @Test
    @Sql(scripts = {"Capstone_Schema.sql"})
    public void addUser() {
        // Arrange


        // Act


        //Assert
    }

    @Test
    @Sql(scripts = {"Capstone_Schema.sql"})
    public void editUser() {
        // Arrange


        // Act


        //Assert
    }

    @Test
    @Sql(scripts = {"Capstone_Schema.sql"})
    public void deleteUser() {
        // Arrange


        // Act


        //Assert
    }
}