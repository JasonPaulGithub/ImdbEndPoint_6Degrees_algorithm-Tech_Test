package com.example.DbLogic.Actor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return User object
 * */
public class ActorRowMapper implements RowMapper<Actor>{

    @Override
    public Actor mapRow(ResultSet resultSet, int i) throws SQLException {

        // Get the result set data
        String nconst = resultSet.getString("nconst");
        String primaryname = resultSet.getString("primaryname");
        int birthyear = resultSet.getInt("birthyear");
        int deathyear = resultSet.getInt("deathyear");
        String primaryprofession = resultSet.getString("primaryprofession");
        String knownfortitles = resultSet.getString("knownfortitles");

        // User object data encapsulated
        Actor actor = new Actor();

        // Set the values
        actor.setNconst(nconst);
        actor.setPrimaryname(primaryname);
        actor.setBirthyear(birthyear);
        actor.setDeathyear(deathyear);
        actor.setPrimaryprofession(primaryprofession);
        actor.setKnownfortitles(knownfortitles);

        return actor;
    }
}