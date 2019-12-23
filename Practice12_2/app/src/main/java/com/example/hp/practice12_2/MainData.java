package com.example.hp.practice12_2;

public class MainData {

    private String txtName;
    private String txtNumber;

    public MainData(String txtName, String txtNumber) {
        this.txtName = txtName;
        this.txtNumber = txtNumber;
    }


    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtNumber() {
        return txtNumber;
    }

    public void setTxtNumber(String txtContent) {
        this.txtNumber = txtContent;
    }
}
