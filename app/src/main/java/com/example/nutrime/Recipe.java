package com.example.nutrime;

import android.media.Image;

import java.util.ArrayList;
import java.util.Dictionary;

public class Recipe {
    private String name;
    private Image picture;
    private String[] description;
    private Properties properties;
    private int rating;
    private double duration;

    Recipe(String name, Image picture, String[] description, Properties properties, int rating, double duration){
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.properties = properties;
        this.rating = rating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
