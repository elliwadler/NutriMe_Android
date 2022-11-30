package com.example.nutrime;

import android.media.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Recipe {
    private String name;
    private int picture;
    private String[] description;

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", picture=" + picture +
                ", description=" + Arrays.toString(description) +
                ", properties=" + properties +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    private Properties properties;
    private int rating;
    private long duration;

    Recipe(String name, int picture, String[] description, Properties properties, int rating, long duration){
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
