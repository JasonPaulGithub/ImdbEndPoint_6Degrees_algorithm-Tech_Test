package com.example.baconator;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Did not end up using this in the end but the idea was to wrap the DB results around the existing logic
 * */
public class PlaceholderRowMapper implements RowMapper<Placeholder> {
    String name;

    // Constructor //
    public PlaceholderRowMapper(String name) {
        this.name = name;
    }

    @Override
    public Placeholder mapRow(ResultSet rs, int rowNum) throws SQLException {

        String dbMovies = rs.getString("knownfortitles");

        Placeholder placeholder = new Placeholder(name);

        placeholder.setDbMovies(dbMovies);

        return placeholder;
    }
}
