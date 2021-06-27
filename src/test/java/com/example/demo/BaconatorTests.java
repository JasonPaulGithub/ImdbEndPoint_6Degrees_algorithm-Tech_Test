package com.example.demo;

import com.example.baconator.Baconator;
import com.example.baconator.Movie;
import com.example.baconator.Placeholder;
import org.junit.jupiter.api.Test;

public class BaconatorTests {

    Placeholder kevin = new Placeholder("Kevin Bacon");
    Movie movie1 = new Movie("Movie 1");

    @Test
    public void testPositiveBacon(){
    }

    @Test
    public void testNegativeBacon(){
        Placeholder actor = new Placeholder("Mr reeves");
        actor.setMovies(new Movie("The Matrix"));
    }

    @Test
    public void testIfNextBacon(){

        Placeholder jeff = new Placeholder("jeff");
        Placeholder steve = new Placeholder("steve");
        jeff.setMovies(movie1);
        movie1.setActors(steve);

        Placeholder dave = new Placeholder("dave");
        Movie movie2 = new Movie("Movie 2");
        steve.setMovies(movie2);
        movie2.setActors(dave);

        Movie movie3 = new Movie("Movie 3");
        dave.setMovies(movie3);
        movie3.setActors(kevin);

        Baconator baconator = new Baconator();
        baconator.assignRoot(jeff);
        baconator.search();
    }

}
