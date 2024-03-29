// The brave Baconite travels the land far and wide to find the rare bacon known as Kevin!
package com.example.baconator;

import java.util.LinkedHashSet;

public class Baconator implements BaconInterface {

    private LinkedHashSet<String> currentRoute = new LinkedHashSet<>();
    private Placeholder actor;

    // Setters and Getters
    public void setCurrentRoute(LinkedHashSet<String> currentRoute) {
        this.currentRoute = currentRoute;
    }
    public void setActor(Placeholder actor) {
        this.actor = actor;
    }
    public int getRouteMapSize(){
        return routeMap.size();
    }

    // Set the first node
    public void assignRoot(Placeholder actor) {
        routeMap.add(actor.name());
        traversed.add(actor.name());
        this.currentRoute.add(actor.name());
        this.actor = actor;
    }

    // Parse the result from the interface
    public String result() {
        return "result: "
                + String.join(",", routeMap)
                + " in " + getRouteMapSize() + " steps";
    }

    // Run our recursive search
    public void search() {
        if (actor.isKevinBacon()) {
            currentRoute.add(actor.name());
            routeMap.addAll(currentRoute);
            System.out.println(result());
        } else {
            for (Movie movie : actor.getMovieList()) {
                //System.out.println("Searching connected Movie : " + movie.title());
                currentRoute.add(movie.title());

                for (Placeholder actor : movie.getActors()) {
                    if (!traversed.contains(actor.name())) {
                        System.out.println("searching " + actor.name());
                        traversed.add(actor.name());
                        currentRoute.add(actor.name());
                        Baconator baconite = new Baconator();
                        baconite.setActor(actor);
                        baconite.setCurrentRoute(currentRoute);
                        baconite.search();
                    //} else {
                        //System.out.println("Actor already searched :" + actor.name());
                        // delete movie from movie.list and check list size, if size=0 return null
                    }
                }
            }
        }
    }

}
