package com.example.baconator;

import java.util.HashMap;
import java.util.Map;

public class Baconator {

    Map<Integer, Placeholder> routeMap = new HashMap<>();

    public Baconator(Placeholder root) {
        routeMap.put(0, root);
    }

    private void assignBaconite(Placeholder subject) {

        if(subject.isKevinBacon()){
            System.out.println("Found him!");
            // refine route
        } else {
            // get randomly selected movie not already cleared
            stepToNextMovie();
        };
    }

    private void stepToNextMovie() {
        // handle with new Baconator? or create Bacon Child?
    }

    public String getRoute() {
        StringBuilder route = new StringBuilder();
        for (int x = 0; x < routeMap.size(); x++) {
            route.append(routeMap.get(x).getActorName()).append(", ");
        }
        route.append(": ").append(routeMap.size()).append(" steps in total.");
        return route.toString();
    }
}

/*
 * create 10 threads
 *
 * thread operations:
 * Set <String movieCheckedList>
 * Set <String actorCheckedList>
 * Set record <Int index, Placeholder actor>

 * load root placeholder, record.add
 * if placeholder != kevin bacon then
 * get list of movies for placeholder
 * select random movie not on checkedList, select random actor not on checkedList
 * repeat cycle
 * if no actors left, add movie to checked list, return to parent node
 *
 * - we could refine and finalize the best route with an A* algorithm
 * */
