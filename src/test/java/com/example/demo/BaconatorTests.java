package com.example.demo;

import com.example.baconator.Baconator;
import com.example.baconator.Movie;
import com.example.baconator.Placeholder;
import org.junit.jupiter.api.Test;

public class BaconatorTests {

    @Test
    public void testPositiveBacon(){
        Placeholder node1 = new Placeholder("Mr reeves");
        node1.setMovies(new Movie("The Matrix"));
        Baconator baconator = new Baconator(node1);
        System.out.println(baconator.assignBaconite(node1));
    }

    @Test
    public void testIfNextBacon(){

        Placeholder jeff = new Placeholder("jeff");
        Placeholder steve = new Placeholder("steve");
        Movie movie1 = new Movie("Movie 1");
        jeff.setMovies(movie1);
        steve.setMovies(movie1);
        movie1.setActors(steve);
        movie1.setActors(jeff);

        Placeholder dave = new Placeholder("dave");
        Movie movie2 = new Movie("Movie 2");
        dave.setMovies(movie2);
        steve.setMovies(movie2);
        movie2.setActors(dave);
        movie2.setActors(steve);

        Movie movie3 = new Movie("Movie 2");
        Placeholder kevin = new Placeholder("Kevin Bacon");
        movie3.setActors(dave);
        movie1.setActors(kevin);
        dave.setMovies(movie3);
        kevin.setMovies(movie3);

        Baconator baconator = new Baconator(jeff);
        System.out.println(baconator.assignBaconite(jeff));
    }

}
