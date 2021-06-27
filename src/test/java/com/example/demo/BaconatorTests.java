package com.example.demo;

import com.example.baconator.Baconator;
import com.example.baconator.Movie;
import com.example.baconator.Placeholder;
import org.junit.jupiter.api.Test;

/**
 * I built this prototype to test the logic. Later on my intention
 * was to replace the hard coded values with values from the database.
 */

public class BaconatorTests {

    @Test
    public void testBaconatorWithoutDbLogic(){

        // Set up the Values for the test
        Placeholder jeff = new Placeholder("Keanu Reeves");
        Placeholder steve = new Placeholder("Bruce Willis");
        Placeholder dave = new Placeholder("Kirsten Dunst");
        Placeholder kevin = new Placeholder("Kevin Bacon");
        Movie movie1 = new Movie("A Beautiful Mind");
        Movie movie2 = new Movie("The Matrix");
        Movie movie3 = new Movie("Die Hard");

        // Set up the logic for the test by linking the actor and movie
        jeff.setMovies(movie1);
        movie1.setActors(steve);

        steve.setMovies(movie2);
        movie2.setActors(dave);

        dave.setMovies(movie3);
        movie3.setActors(kevin);

        // We set up the object and assign its base value and search with recursion included
        Baconator baconator = new Baconator();
        baconator.assignRoot(jeff);
        baconator.search();

        // We assert the final values of the test
        assert (baconator.getRouteMapSize() == 7);

    }

}
