package com.example.hp.gridviewtest;


public class MyData {
    private Integer posterID;
    private String posterTitle;

    public String getPosterTitle() {
        return posterTitle;
    }

    public void setPosterTitle(String posterTitle) {
        this.posterTitle = posterTitle;
    }

    public MyData(Integer posterID, String posterTitle) {
        this.posterID = posterID;
        this.posterTitle = posterTitle;
    }

    public MyData(Integer posterID) {
        this.posterID = posterID;
    }

    public Integer getPosterID() {
        return posterID;
    }

    public void setPosterID(Integer posterID) {
        this.posterID = posterID;
    }
}