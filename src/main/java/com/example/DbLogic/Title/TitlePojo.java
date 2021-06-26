package com.example.DbLogic.Title;

public class TitlePojo {

    private String tconst;
    private String titletype;
    private String primarytitle;
    private String originaltitle;
    private Boolean isadult;
    private int startyear;
    private int endyear;
    private String runtimeminutes;
    private String genres;

    @Override
    public String toString() {
        return "primarytitle: " + primarytitle
                + ", originaltitle: " + originaltitle
                + ", titletype: " + titletype
                + ", isadult: " + isadult
                + ", startyear: " + startyear
                + ", endyear: " + endyear
                + ", runtimeminutes: " + runtimeminutes
                + " genres: " + genres
                ;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getTitletype() {
        return titletype;
    }

    public void setTitletype(String titletype) {
        this.titletype = titletype;
    }

    public String getPrimarytitle() {
        return primarytitle;
    }

    public void setPrimarytitle(String primarytitle) {
        this.primarytitle = primarytitle;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public Boolean getIsadult() {
        return isadult;
    }

    public void setIsadult(Boolean isadult) {
        this.isadult = isadult;
    }

    public int getStartyear() {
        return startyear;
    }

    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }

    public int getEndyear() {
        return endyear;
    }

    public void setEndyear(int endyear) {
        this.endyear = endyear;
    }

    public String getRuntimeminutes() {
        return runtimeminutes;
    }

    public void setRuntimeminutes(String runtimeminutes) {
        this.runtimeminutes = runtimeminutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

}
