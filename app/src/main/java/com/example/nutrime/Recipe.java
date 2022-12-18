package com.example.nutrime;

import com.example.nutrime.enums.MustHaves;
import com.example.nutrime.enums.NoGos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe {
    private String name;
    private int picture;
    private String[] description;
    private final List<String[]> ingredients;
    private Map<MustHaves, Float> mustHaves;
    private Map<NoGos, Boolean> noGos;
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
           long duration, List<String[]> ingredients, Map<NoGos, Boolean> noGos) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.mustHaves = mustHaves;
        this.rating = rating;
        this.duration = duration;
        this.ingredients = ingredients;
        this.noGos = noGos;
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

    public String getPreparationTimePrettyPrint() {
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

    // Getting the highest 3 nutrients from the must haves
    // todo: convert to relative value first, sorting by absolute makes no sense
    // idea: create conversion class which takes nutrient enum and absolut value, then returns relative value
    public ArrayList<MustHaves> getBestIngredients() {
        return getMustHaves().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<NoGos, Boolean> getNoGos() {
        return noGos;
    }

    public void setNoGos(Map<NoGos, Boolean> noGos) {
        this.noGos = noGos;
    }
}
