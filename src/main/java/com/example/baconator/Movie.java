package com.example.baconator;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String movieTitle;
    private List<Placeholder> actors = new ArrayList<>();

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public List<Placeholder> getActors() {
        return actors;
    }

    public void setActors(Placeholder actor) {
        this.actors.add(actor);
    }
}
