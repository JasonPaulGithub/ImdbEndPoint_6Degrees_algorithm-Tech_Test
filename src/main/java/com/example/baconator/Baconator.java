package com.example.baconator;

import static com.example.baconator.BaconInterface.*;

public class Baconator {

    // Constructor
    public Baconator(Placeholder root) {
        routeMap.add(root.getActorName());
    }

    public String assignBaconite(Placeholder actor) {
        Baconite loyalBaconite = new Baconite(actor);
        if (loyalBaconite.getResult()){
            return "result: " + String.join(",", routeMap) + " in " + routeMap.size() + " steps";
        } else {
            return "Could not find the bacon!";
        }
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
