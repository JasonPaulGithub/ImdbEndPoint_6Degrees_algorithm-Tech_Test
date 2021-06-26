package com.example.DbLogic.TitleRated;


import com.example.DbLogic.Title.TitleObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TitleRateRowMapper implements RowMapper<TitleRatedObject> {

    @Override
    public TitleRatedObject mapRow(ResultSet resultSet, int rowNum) throws SQLException {

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
        String averagerating = resultSet.getString("averagerating");
        int numvotes = resultSet.getInt("numvotes");

        // TitleObject object data encapsulated
        TitleRatedObject titleObject = new TitleRatedObject();

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
        titleObject.setAveragerating(averagerating);
        titleObject.setNumvotes(numvotes);

        return titleObject;
    }
}
