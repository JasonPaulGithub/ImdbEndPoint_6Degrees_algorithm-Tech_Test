package com.example.DbLogic.Title;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return Actor object
 * */

public class TitleRowMapper implements RowMapper<TitlePojo> {

    @Override
    public TitlePojo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

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

        // TitleObject object data encapsulated
        TitlePojo titlePojo = new TitlePojo();

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

        return titlePojo;
    }
}
