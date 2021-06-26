package com.example.DbLogic.Title;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implement interfaces, return Actor object
 * */

public class TitleRowMapper implements RowMapper<TitleObject> {
    @Override
    public TitleObject mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        // Get the result set data
        String tconst = resultSet.getString("tconst");
        String titletype = resultSet.getString("titletype");
        String primarytitle = resultSet.getString("primarytitle");
        String originaltitle = resultSet.getString("originaltitle");
        String isadult = resultSet.getString("isadult");
        String startyear = resultSet.getString("startyear");
        String endyear = resultSet.getString("endyear");
        String runtimeminutes = resultSet.getString("runtimeminutes");
        String genres = resultSet.getString("genres");

        // TitleObject object data encapsulated
        TitleObject titleObject = new TitleObject();

        // Set the values
        titleObject.setTconst(tconst);
        titleObject.setTitletype(titletype);
        titleObject.setPrimarytitle(primarytitle);
        titleObject.setOriginaltitle(originaltitle);
        titleObject.setIsadult(isadult);
        titleObject.setStartyear(startyear);
        titleObject.setEndyear(endyear);
        titleObject.setRuntimeminutes(runtimeminutes);
        titleObject.setGenres(genres);

        return null;
    }
}
