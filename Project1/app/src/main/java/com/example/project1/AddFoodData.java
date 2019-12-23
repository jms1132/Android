package com.example.project1;

public class AddFoodData {
    private String bigCategory;
    private String smallCategory;
    private String imageID;

    public AddFoodData(String bigCategory, String smallCategory, String imageID) {
        this.bigCategory = bigCategory;
        this.smallCategory = smallCategory;
        this.imageID = imageID;
    }

    public String getBigCategory() {
        return bigCategory;
    }

    public void setBigCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }

    public String getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
