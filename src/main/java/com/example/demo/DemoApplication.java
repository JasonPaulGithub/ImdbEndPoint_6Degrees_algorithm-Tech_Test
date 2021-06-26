package com.example.demo;

import com.example.demo.DbLogic.MyRowMapper;
import com.example.demo.DbLogic.Actor;
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
		String actor = findActorbyId("nm0000001").toString();
		System.out.println(actor);
	}

	public Actor findActorbyId(String id) {
			String sql = "select * from name_basics where name_basics.nconst = ?";
			return jdbcTemplate.queryForObject(sql, new MyRowMapper(), id);
	}

	public void count() {
		String sql = "SELECT COUNT(*) FROM public.name_basics";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println ( "The total number of data:" + count);
	}
}
