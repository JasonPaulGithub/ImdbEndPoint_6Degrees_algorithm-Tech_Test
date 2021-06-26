package com.example.DbLogic.TitleRated;

import com.example.DbLogic.Title.TitleObject;

public class TitleRatedObject extends TitleObject {

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
