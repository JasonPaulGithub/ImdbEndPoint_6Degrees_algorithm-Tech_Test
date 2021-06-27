package com.example.baconator;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String movieTitle;
    private final List<Placeholder> actors = new ArrayList<>();

    public String title() {
        return movieTitle;
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
