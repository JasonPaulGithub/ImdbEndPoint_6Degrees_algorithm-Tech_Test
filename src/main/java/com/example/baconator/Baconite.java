package com.example.baconator;

import java.util.List;
import java.util.Set;

// The brave Baconite travels the land far and wide to find the rare bacon known as Kevin.
public class Baconite implements BaconInterface{

    private final Placeholder actor;
    private final Set<String> currentRoute;
    
    public Baconite(Placeholder actor, Set<String> route) {
        this.currentRoute = route;
        this.actor = actor;
    }

    public boolean getResult() {
        if(actor.isKevinBacon()){
            routeMap.addAll(currentRoute);
            return true;
        } else {
            List<Movie> movies = actor.getMovieList();
            for (Movie movie: movies) {
                for (Placeholder actor : movie.getActors()){
                    new Baconite(actor, currentRoute);
                }
            }
            return false;
        }
    }
}
