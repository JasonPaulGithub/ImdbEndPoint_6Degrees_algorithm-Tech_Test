package com.example.demo;

import com.example.dbLogic.TitleCrew.TitleCrewPojo;
import com.example.dbLogic.TitleCrew.TitleCrewRowMapper;
import com.example.dbLogic.TitleRated.TitleRateRowMapper;
import com.example.dbLogic.TitleRated.TitleRatePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        sixDegreesOfKevinBacon("Bruce Lee");
    }

    private void sixDegreesOfKevinBacon(String name) {
        // Please check com.example.demo.BaconatorTests //
    }

    /**
     * Search by movie’s primary title.
     * http://localhost:8080/primarytitle?title=Post%20No%20Bills
     */
    @RestController
    public class findByPrimaryTitle {
        @GetMapping("/primarytitle")
        public List<TitleCrewPojo> primaryTitle(
                @RequestParam(value = "title", defaultValue = "Effets de mer sur les rochers") String title) {
            String sql =
                    "SELECT * FROM title_basics INNER JOIN title_crew " +
                            "ON title_basics.tconst = title_crew.tconst " +
                            "WHERE title_basics.primarytitle = ?";
            return jdbcTemplate.query(sql, new TitleCrewRowMapper(jdbcTemplate), title);
        }
    }

    /**
     * Search by movie’s original title.
     * http://localhost:8080/originaltitle?title=Carmencita
     */
    @RestController
    public class findByOriginalTitle {
        @GetMapping("/originaltitle")
        public List<TitleCrewPojo> originalTitle(
                @RequestParam(value = "title") String title) {
            String sql =
                    "SELECT * FROM title_basics INNER JOIN title_crew " +
                            "ON title_basics.tconst = title_crew.tconst " +
                            "WHERE title_basics.originaltitle = ?";
            return jdbcTemplate.query(sql, new TitleCrewRowMapper(jdbcTemplate), title);
        }
    }

    /**
     * Top rated movies: Given a query by the user:
     * http://localhost:8080/genre?genre=Short
     */
    @RestController
    public class topRatedByGenreController {
        @GetMapping("/genre")
        public List<TitleRatePojo> titleRate(@RequestParam(value = "genre", defaultValue = "Horror") String genre) {
            String sql
                    = "SELECT * FROM title_ratings INNER JOIN title_basics " +
                    "ON title_ratings.tconst = title_basics.tconst WHERE title_basics.genres " +
                    "LIKE '" + genre + "' ORDER BY title_ratings.averagerating DESC LIMIT 10";
            return jdbcTemplate.query(sql, new TitleRateRowMapper());
        }
    }

}
