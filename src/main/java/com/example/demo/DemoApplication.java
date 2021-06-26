package com.example.demo;

import com.example.DbLogic.Actor.ActorRowMapper;
import com.example.DbLogic.Actor.ActorObject;
import com.example.DbLogic.Title.TitleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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
		System.out.println(findActorbyId("nm0000001").toString());


		// API to search by original title


		/*
			### Requirement #2 (easy):
			Top rated movies: Given a query by the user, you must provide what are the top
			rated movies for a genre (If the actor searches horror, then it should show a
			list of top rated horror movies).
		*/

		// Filter top rated movies by genre

		/*
			### Requirement #3 (difficult):
			[Six degrees of Kevin
			Bacon](https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon): Given a query
			by the user, you must provide what’s the degree of separation between the person
			(e.g. actor or actress) the user has entered and Kevin Bacon.
		*/

		// The Baconator
	}

	// select * from title_basics where title_basics.primaryTitle = 'Carmencita'

	public TitleObject findByPrimaryTitle(String id) {
		String sql = "select * from title_basics where title_basics.originalTitle = ?";
		return null;
	}

	public TitleObject findByOriginalTitle(String id) {
		String sql = "select * from title_basics where title_basics.primaryTitle = ?";
		return null;
	}

	public ActorObject findActorbyId(String id) {
			String sql = "select * from name_basics where name_basics.nconst = ?";
			return jdbcTemplate.queryForObject(sql, new ActorRowMapper(), id);
	}

	public void count() {
		String sql = "SELECT COUNT(*) FROM public.name_basics";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println ( "The total number of data:" + count);
	}
}
