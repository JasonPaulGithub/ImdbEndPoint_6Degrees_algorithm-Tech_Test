package com.example.baconator;

import java.util.ArrayList;
import java.util.List;

public class Placeholder {

    /**
     * I wanted to avoid reusing the name "actor" , so "placeholder" was used to also determine writers, directors, etc
     */

    private final List<Movie> movies = new ArrayList<>();
    private final String actorName;

    public Placeholder(String name) {
        this.actorName = name;
    }

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }

    public void setDbMovies(String dbMovies) {
        System.out.println(movies);
    }

    public String name() {
        return actorName;
    }

    public boolean isKevinBacon() {
        return actorName.contentEquals("Kevin Bacon");
    }
}
