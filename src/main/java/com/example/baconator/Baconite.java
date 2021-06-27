// The brave Baconite travels the land far and wide to find the rare bacon known as Kevin.

package com.example.baconator;

import java.util.List;
import java.util.Set;

public class Baconite implements BaconInterface {

    private final Placeholder actor;
    private final Set<String> currentRoute = null;

    public Baconite(Placeholder actor) {
        this.actor = actor;
    }

    public boolean getResult() {
        for (Movie movie : actor.getMovieList()) {
            System.out.println(movie.getMovieTitle());
            routeMap.add(movie.getMovieTitle());

            for (Placeholder actor : movie.getActors()) {
                System.out.println(actor.getActorName());

                if (actor.isKevinBacon()) {
                    return true;
                } else {
                    if(traversed.contains(actor.getActorName())){
                        routeMap.add(actor.getActorName());
                        traversed.add(actor.getActorName());
                        new Baconite(actor).getResult();
                    }
                }

            }
        }
        return false;
    }
}
