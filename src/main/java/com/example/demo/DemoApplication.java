package com.example.demo;

import com.example.ApiLogic.Greeting;
import com.example.DbLogic.Actor.ActorRowMapper;
import com.example.DbLogic.Actor.ActorObject;
import com.example.DbLogic.Title.TitleObject;
import com.example.DbLogic.Title.TitleRowMapper;
import com.example.DbLogic.TitleRated.TitleRateRowMapper;
import com.example.DbLogic.TitleRated.TitleRatedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
			### Requirement #1 (easy):
			IMDb copycat: Present the user with endpoint for allowing them to search by
			movie’s primary title or original title. The outcome should be related
			information to that title, including cast and crew.
		*/

		// API to search by primary title
		System.out.println("API to search by primary title::");
		findByPrimaryTitle("Carmencita");

		// API to search by original title
		System.out.println("API to search by original title::");
		findByOriginalTitle("Carmencita");

		/*
			### Requirement #2 (easy):
			Top rated movies: Given a query by the user, you must provide what are the top
			rated movies for a genre (If the user searches horror, then it should show a
			list of top rated horror movies).
		*/
		System.out.println("topRatedByGenre::");
		topRatedByGenre("Horror");

		/*
			### Requirement #3 (difficult):
			[Six degrees of Kevin
			Bacon](https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon): Given a query
			by the user, you must provide what’s the degree of separation between the person
			(e.g. actor or actress) the user has entered and Kevin Bacon.
		*/

		// The Brute Baconator
	}

	public void findByPrimaryTitle(String id) {
		String sql = "select * from title_basics where title_basics.primarytitle = ?";
		List<TitleObject> titles = jdbcTemplate.query(sql, new TitleRowMapper(), id);
		System.out.println(titles);
	}

	public void findByOriginalTitle(String id) {
		String sql = "select * from title_basics where title_basics.originaltitle = ?";
		List<TitleObject> titles = jdbcTemplate.query(sql, new TitleRowMapper(), id);
		System.out.println(titles);
	}

	public void topRatedByGenre(String genre){
		String sql
				= "SELECT * FROM title_ratings INNER JOIN title_basics " +
				"ON title_ratings.tconst = title_basics.tconst WHERE title_basics.genres " +
				"LIKE '"+ genre +"' ORDER BY title_ratings.averagerating DESC LIMIT 10";
		List<TitleRatedObject> titles = jdbcTemplate.query(sql, new TitleRateRowMapper());
		System.out.println(titles);
	}

	public void getCastAndCrew(String tconst) {
		// query and return cast and crew via object
		// and process their actor id
	}

	public ActorObject findActorbyId(String id) {
			String sql = "select * from name_basics where name_basics.nconst = ?";
			return jdbcTemplate.queryForObject(sql, new ActorRowMapper(), id);
	}

	public TitleObject findTitleById(String id) {
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
