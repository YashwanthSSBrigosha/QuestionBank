package com.example.questionbank;

public class Questions {

    private String title;
    private  int imgRes;

    public Questions(String title, int imgRes) {
        this.title = title;
        this.imgRes = imgRes;
    }

    public String getTitle() {
        return title;
    }

    public int getImgRes() {
        return imgRes;
    }
}
