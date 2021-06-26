package com.example.demo;

import com.example.DbLogic.Actor.ActorRowMapper;
import com.example.DbLogic.Actor.ActorPojo;
import com.example.DbLogic.Crew.CrewPojo;
import com.example.DbLogic.Crew.CrewRowMapper;
import com.example.DbLogic.Title.TitlePojo;
import com.example.DbLogic.Title.TitleRowMapper;
import com.example.DbLogic.TitleCrew.TitleCrewPojo;
import com.example.DbLogic.TitleCrew.TitleCrewRowMapper;
import com.example.DbLogic.TitleRated.TitleRateRowMapper;
import com.example.DbLogic.TitleRated.TitleRatePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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

		// ### Warmup: Find Actor by ID
		System.out.println(findActorbyId("nm0000001").toString());

		/*
			IMDb copycat: Present the user with endpoint for allowing them to search by
			movie’s primary title or original title. The outcome should be related
			information to that title, including cast and crew.
		*/

		// API to search by primary title
		System.out.println("API to search by primary title::");
		findByPrimaryTitle("Miss Jerry");

		// API to search by original title
		System.out.println("API to search by original title::");
		findByOriginalTitle("Miss Jerry");

		/*
			Top rated movies: Given a query by the user, you must provide what are the top
			rated movies for a genre (If the user searches horror, then it should show a
			list of top rated horror movies).
		*/
		System.out.println("topRatedByGenre::");
		topRatedByGenre("Horror");

		/*
			Six degrees of Kevin Bacon :
			Given a query by the user, you must provide what’s the degree of separation between the person
			(e.g. actor or actress) the user has entered and Kevin Bacon.
		*/

		// The Brute Baconator
	}

	public void findByPrimaryTitle(String id) {
		String sql =
				"SELECT * FROM title_basics INNER JOIN title_crew " +
				"ON title_basics.tconst = title_crew.tconst " +
				"WHERE title_basics.primarytitle = ?";
		List<TitleCrewPojo> titles = jdbcTemplate.query(sql, new TitleCrewRowMapper(jdbcTemplate), id);

		System.out.println(titles);
	}

	public void findByOriginalTitle(String id) {
		String sql =
				"SELECT * FROM title_basics INNER JOIN title_crew " +
						"ON title_basics.tconst = title_crew.tconst " +
						"WHERE title_basics.originaltitle = ?";
		List<TitleCrewPojo> titles = jdbcTemplate.query(sql, new TitleCrewRowMapper(jdbcTemplate), id);
		System.out.println(titles);
	}

	public void topRatedByGenre(String genre){
		String sql
				= "SELECT * FROM title_ratings INNER JOIN title_basics " +
				"ON title_ratings.tconst = title_basics.tconst WHERE title_basics.genres " +
				"LIKE '"+ genre +"' ORDER BY title_ratings.averagerating DESC LIMIT 10";
		List<TitleRatePojo> titles = jdbcTemplate.query(sql, new TitleRateRowMapper());
		System.out.println(titles);
	}

	public void getCastAndCrew(String nconst) {
		String sql = "select * from name_basics where name_basics.nconst = ?";
		List<ActorPojo> titles = jdbcTemplate.query(sql, new ActorRowMapper(), nconst);
		System.out.println(titles);
	}

	public ActorPojo findActorbyId(String id) {
		String sql = "select * from name_basics where name_basics.nconst = ?";
		return jdbcTemplate.queryForObject(sql, new ActorRowMapper(), id);
	}

	public TitlePojo findTitleById(String id) {
		String sql = "select * from title_basics where title_basics.tconst = ?";
		return jdbcTemplate.queryForObject(sql, new TitleRowMapper(), id);
	}

	/*
		@RestController
	public class GreetingController {

		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();

		@GetMapping("/greeting")
		public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}
	}
	*/
}
