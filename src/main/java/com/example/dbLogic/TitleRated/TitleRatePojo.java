package com.example.dbLogic.TitleRated;

import com.example.dbLogic.Title.TitlePojo;

public class TitleRatePojo extends TitlePojo {

    private String averagerating;
    private int numvotes;

    public String getAveragerating() {
        return averagerating;
    }
    public void setAveragerating(String averagerating) {
        this.averagerating = averagerating;
    }
    public int getNumvotes() {
        return numvotes;
    }
    public void setNumvotes(int numvotes) {
        this.numvotes = numvotes;
    }

}
