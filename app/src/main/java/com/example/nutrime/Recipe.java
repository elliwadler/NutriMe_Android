package com.example.nutrime;

import com.example.nutrime.enums.MustHaves;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Recipe {
    private String name;
    private int picture;
    private String[] description;
    private List<String[]> ingredients;
    private Map<MustHaves, Float> mustHaves;
    private int rating;
    private long duration;

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", picture=" + picture +
                ", description=" + Arrays.toString(description) +
                ", properties=" + mustHaves +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    Recipe(String name, int picture, String[] description, Map<MustHaves, Float> mustHaves, int rating,
           long duration, List<String[]> ingredients) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.mustHaves = mustHaves;
        this.rating = rating;
        this.duration = duration;
        this.ingredients = ingredients;
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

    public Map<MustHaves, Float> getMustHaves() {
        return mustHaves;
    }

    public void setMustHaves(Map<MustHaves, Float> mustHaves) {
        this.mustHaves = mustHaves;
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
        return ingredients;
    }

}
