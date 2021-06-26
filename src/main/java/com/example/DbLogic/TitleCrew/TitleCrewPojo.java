package com.example.DbLogic.TitleCrew;

import com.example.DbLogic.Actor.ActorPojo;
import com.example.DbLogic.Title.TitlePojo;

import java.util.List;

public class TitleCrewPojo extends TitlePojo {

    @Override
    public String toString() {
        return "primarytitle: " + this.getPrimarytitle()
                + ", titletype: " + this.getTitletype()
                + ", primarytitle: " + this.getPrimarytitle()
                + ", originaltitle: " + this.getOriginaltitle()
                + ", isadult: " + this.getIsadult()
                + ", startyear: " + this.getStartyear()
                + ", endyear: " + this.getEndyear()
                + ", runtimeminutes: " + this.getRuntimeminutes()
                + ", genres: " + this.getGenres()
                + ", directors: " + getCrewNames(directors)
                + ", writers: " + getCrewNames(writers)
                ;
    }

    private List<ActorPojo> directors;
    private List<ActorPojo> writers;

    public String getCrewNames(List<ActorPojo> crewList) {
        StringBuilder c = new StringBuilder();
        for (ActorPojo crew: crewList){
            c.append(crew.getPrimaryname());
        }
        return c.toString();
    }
    public void setDirectors(List<ActorPojo> directors) {
        this.directors = directors;
    }

    public void setWriters(List<ActorPojo> writers) {
        this.writers = writers;
    }

}
