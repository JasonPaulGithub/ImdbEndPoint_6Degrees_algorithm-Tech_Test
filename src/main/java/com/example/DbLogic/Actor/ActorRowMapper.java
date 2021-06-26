package com.example.DbLogic.Actor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return Actor object
 * */
public class ActorRowMapper implements RowMapper<ActorObject>{

    @Override
    public ActorObject mapRow(ResultSet resultSet, int i) throws SQLException {

        // Get the result set data
        String nconst = resultSet.getString("nconst");
        String primaryname = resultSet.getString("primaryname");
        int birthyear = resultSet.getInt("birthyear");
        int deathyear = resultSet.getInt("deathyear");
        String primaryprofession = resultSet.getString("primaryprofession");
        String knownfortitles = resultSet.getString("knownfortitles");

        // ActorObject object data encapsulated
        ActorObject actorObject = new ActorObject();

        // Set the values
        actorObject.setNconst(nconst);
        actorObject.setPrimaryname(primaryname);
        actorObject.setBirthyear(birthyear);
        actorObject.setDeathyear(deathyear);
        actorObject.setPrimaryprofession(primaryprofession);
        actorObject.setKnownfortitles(knownfortitles);

        return actorObject;
    }
}