package com.example.DbLogic.TitleCrew;

import com.example.DbLogic.Actor.ActorPojo;
import com.example.DbLogic.Actor.ActorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TitleCrewRowMapper implements RowMapper {

    JdbcTemplate jdbcTemplate;

    public TitleCrewRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        // Get the result set data
        String tconst = resultSet.getString("tconst");
        String titletype = resultSet.getString("titletype");
        String primarytitle = resultSet.getString("primarytitle");
        String originaltitle = resultSet.getString("originaltitle");
        Boolean isadult = resultSet.getBoolean("isadult");
        int startyear = resultSet.getInt("startyear");
        int endyear = resultSet.getInt("endyear");
        String runtimeminutes = resultSet.getString("runtimeminutes");
        String genres = resultSet.getString("genres");

        String directorIds = resultSet.getString("directors");
        String writerIds = resultSet.getString("writers");

        // TitleObject object data encapsulated
        TitleCrewPojo titlePojo = new TitleCrewPojo();

        // Set the values
        titlePojo.setTconst(tconst);
        titlePojo.setTitletype(titletype);
        titlePojo.setPrimarytitle(primarytitle);
        titlePojo.setOriginaltitle(originaltitle);
        titlePojo.setIsadult(isadult);
        titlePojo.setStartyear(startyear);
        titlePojo.setEndyear(endyear);
        titlePojo.setRuntimeminutes(runtimeminutes);
        titlePojo.setGenres(genres);

        String sql = "select * from name_basics where name_basics.nconst = ?";
        List<ActorPojo> directors = jdbcTemplate.query(sql, new ActorRowMapper(), directorIds);
        titlePojo.setDirectors(directors);

        List<ActorPojo> writers = jdbcTemplate.query(sql, new ActorRowMapper(), writerIds);
        titlePojo.setWriters(writers);

        return titlePojo;
    }


}
