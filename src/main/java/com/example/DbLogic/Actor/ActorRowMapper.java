package com.example.DbLogic.Actor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return Actor object
 * */
public class ActorRowMapper implements RowMapper<ActorPojo>{

    @Override
    public ActorPojo mapRow(ResultSet resultSet, int i) throws SQLException {

        // Get the result set data
        String nconst = resultSet.getString("nconst");
        String primaryname = resultSet.getString("primaryname");
        int birthyear = resultSet.getInt("birthyear");
        int deathyear = resultSet.getInt("deathyear");
        String primaryprofession = resultSet.getString("primaryprofession");
        String knownfortitles = resultSet.getString("knownfortitles");

        // ActorObject object data encapsulated
        ActorPojo actorPojo = new ActorPojo();

        // Set the values
        actorPojo.setNconst(nconst);
        actorPojo.setPrimaryname(primaryname);
        actorPojo.setBirthyear(birthyear);
        actorPojo.setDeathyear(deathyear);
        actorPojo.setPrimaryprofession(primaryprofession);
        actorPojo.setKnownfortitles(knownfortitles);

        return actorPojo;
    }
}