package com.example.demo;

import com.example.demo.DbLogic.MyRowMapper;
import com.example.demo.DbLogic.User;
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
	public void run(String... args) throws Exception {
		findOne();
	}

	public void findOne() {
			String sql = "select * from user where name = ?";
			User actor = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "Tom");
			System.out.println(actor);
	}

	public void count() {
		String sql = "SELECT COUNT(*) FROM public.name_basics";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println ( "The total number of data:" + count);
	}
}
