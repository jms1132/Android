package com.example.hp.mylistviewcreatertest;
public class MyCustomDTO {

    String title;
    String content;
    int imgIcon;
    int imgIcon1;


    public MyCustomDTO(int imgIcon, String title, String content, int imgIcon1) {
        this.title = title;
        this.content = content;
        this.imgIcon = imgIcon;
        this.imgIcon1 = imgIcon1;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getImgIcon() {
        return imgIcon;
    }
    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    public int getImgIcon1() {
        return imgIcon1;
    }

    public void setImgIcon1(int imgIcon1) {
        this.imgIcon1 = imgIcon1;
    }
}
