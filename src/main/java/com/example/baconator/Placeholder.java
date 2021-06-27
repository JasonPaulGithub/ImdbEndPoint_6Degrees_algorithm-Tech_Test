package com.example.baconator;

import java.util.ArrayList;
import java.util.List;

public class Placeholder {

    private boolean isKevinBacon = false;
    private List<Movie> movies = new ArrayList<>();

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

    public String getActorName() {
        return actorName;
    }

    public boolean isKevinBacon() {
        return actorName.contentEquals("Kevin Bacon");
    }
}
