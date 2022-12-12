package com.example.nutrime;

import android.media.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class Recipe {
    private String name;
    private int picture;
    private String[] description;
    private List<String[]> ingredints;

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

    Recipe(String name, int picture, String[] description, Properties properties, int rating, long duration, List<String[]> ingredints){
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.properties = properties;
        this.rating = rating;
        this.duration = duration;
        this.ingredints = ingredints;
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

    public String getDuration() {
        String output ="";
        long h = this.duration / 60;
        long m = this.duration % 60;

        if(h != 0 && m!=0)
            output = h+" Std. "+m+" Min.";
        else if(h == 0 && m!=0)
            output = m+" Min.";
        else
            output = h+" Std. ";

       return output;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<String[]> getIngredients() {
        return ingredints;
    }

}
