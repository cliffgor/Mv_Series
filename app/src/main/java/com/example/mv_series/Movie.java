package com.example.mv_series;

public class Movie {

    private String Title;
    private String Description;
    private int thumbnail;
    private String studio;
    private String rating;
    private String streamingLink;


    public Movie(String title, int thumbnail) {
        Title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        Title = title;
        Description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

//    GETTERS


    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

//    SETTERS


    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
