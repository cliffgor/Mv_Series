package com.example.mv_series.models;

public class Slide {
    private int Image;
    private String Title;

    public Slide(int image, String title) {
        Image = image;
        Title = title;
    }

//    GETTERS

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

//    SETTERS


    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
