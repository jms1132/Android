package com.example.project1;
public class Main3Data {

    private int imgProfile;
    private String txtName;
    private String txtContent;
    private boolean isSelected;

    public Main3Data(int imgProfile, String txtName, String txtContent, boolean isSelected) {
        this.imgProfile = imgProfile;
        this.txtName = txtName;
        this.txtContent = txtContent;
        this.isSelected = isSelected;
    }

    public Main3Data(int imgProfile, String txtName, String txtContent) {
        this.imgProfile = imgProfile;
        this.txtName = txtName;
        this.txtContent = txtContent;
    }

    public Main3Data(int imgProfile, String txtName) {
        this.imgProfile = imgProfile;
        this.txtName = txtName;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}