package com.example.DbLogic.Crew;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CrewRowMapper implements RowMapper<CrewObject> {

    @Override
    public CrewObject mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        // Get the result set data
        String tconst = resultSet.getString("tconst");
        String directors = resultSet.getString("directors");
        String writers = resultSet.getString("writers");

        // ActorObject object data encapsulated
        CrewObject crewObject = new CrewObject();

        // Set the values
        crewObject.setTconst(tconst);
        crewObject.setDirectors(directors);
        crewObject.setWriters(writers);

        return crewObject;
    }
}
