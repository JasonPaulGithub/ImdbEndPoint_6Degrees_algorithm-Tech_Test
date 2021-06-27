package com.example.baconator;

import java.util.List;

public class Placeholder {

    private boolean isKevinBacon = false;
    private List<Movie> movies;

    private String actorName;

    public List<Movie> getMovies() {
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
