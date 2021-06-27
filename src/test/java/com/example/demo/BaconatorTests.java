package com.example.demo;

import com.example.baconator.Baconator;
import com.example.baconator.Movie;
import com.example.baconator.Placeholder;
import org.junit.jupiter.api.Test;

public class BaconatorTests {

    @Test
    public void testPositiveBacon(){
        Placeholder node1 = new Placeholder();
        node1.setActorName("Kevin Bacon");
        Baconator baconator = new Baconator(node1);
        System.out.println(baconator.getRoute());;
    }

    @Test
    public void testIfNextBacon(){
        Placeholder node1 = new Placeholder();
        node1.setActorName("Sam Bacon");
        node1.setMovies(new Movie("The Matrix"));
        node1.setMovies(new Movie("Crocodile Dundee"));
        node1.setMovies(new Movie("The Cube"));
        Baconator baconator = new Baconator(node1);
        System.out.println(baconator.getRoute());;
    }

}
