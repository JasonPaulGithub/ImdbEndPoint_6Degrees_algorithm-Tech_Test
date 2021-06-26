package com.example.demo.DbLogic;

/**
 * Data encapsulation class
 * */

public class Actor {

    private String nconst;
    private String primaryname;
    private int birthyear;
    private int deathyear;
    private String primaryprofession;
    private String knownfortitles;

    public String getPrimaryprofession() {
        return primaryprofession;
    }
    public void setPrimaryprofession(String primaryprofession) {
        this.primaryprofession = primaryprofession;
    }
    public String getKnownfortitles() {
        return knownfortitles;
    }
    public void setKnownfortitles(String knownfortitles) {
        this.knownfortitles = knownfortitles;
    }
    public int getDeathyear() {
        return deathyear;
    }
    public void setDeathyear(int deathyear) {
        this.deathyear = deathyear;
    }
    public int getBirthyear() {
        return birthyear;
    }
    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }
    public String getNconst() {
        return nconst;
    }
    public void setNconst(String nconst) {
        this.nconst = nconst;
    }
    public String getPrimaryname() {
        return primaryname;
    }
    public void setPrimaryname(String primaryname) {
        this.primaryname = primaryname;
    }

    @Override
    public String toString() {
        return  "Your ID search returns " + primaryname
                + ". Born in: " + birthyear
                + ". Death: " + deathyear
                + ". Their profession(s) are: " + primaryprofession;
    }
}
