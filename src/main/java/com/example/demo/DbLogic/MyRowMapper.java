package com.example.demo.DbLogic;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return User object
 * */
public class MyRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        // Get the result set data
        String name = resultSet.getString("name");
        String age = resultSet.getString("age");
        // User object data encapsulated
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}