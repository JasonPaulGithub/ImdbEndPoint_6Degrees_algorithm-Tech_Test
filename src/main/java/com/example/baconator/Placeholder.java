package com.example.baconator;

import java.util.ArrayList;
import java.util.List;

public class Placeholder {

    private final List<Movie> movies = new ArrayList<>();

    private String actorName;

    public Placeholder(String name) {
        this.actorName = name;
    }

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String name() {
        return actorName;
    }

    public boolean isKevinBacon() {
        return actorName.contentEquals("Kevin Bacon");
    }
}
