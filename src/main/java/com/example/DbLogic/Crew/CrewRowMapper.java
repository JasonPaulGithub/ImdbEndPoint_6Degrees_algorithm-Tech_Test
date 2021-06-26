package com.example.DbLogic.Crew;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CrewRowMapper implements RowMapper<CrewPojo> {

    @Override
    public CrewPojo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        // Get the result set data
        String tconst = resultSet.getString("tconst");
        String directors = resultSet.getString("directors");
        String writers = resultSet.getString("writers");

        // ActorObject object data encapsulated
        CrewPojo crewPojo = new CrewPojo();

        // Set the values
        crewPojo.setTconst(tconst);
        crewPojo.setDirectors(directors);
        crewPojo.setWriters(writers);

        return crewPojo;
    }
}
