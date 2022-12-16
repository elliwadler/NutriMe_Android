package com.example.nutrime.dal;

import com.example.nutrime.Recipe;
import com.example.nutrime.enums.MustHaves;

import java.util.List;

public class Comparator implements java.util.Comparator<Recipe> {

    private List<MustHaves> mustHaves;

    public Comparator(List<MustHaves> mustHaves) {
        this.mustHaves = mustHaves;
    }

    @Override
    public int compare(Recipe recipe, Recipe t1) {
        if (getScore(recipe) > getScore(t1)) {
            return -1;
        }
        else if (getScore(recipe) < getScore(t1)) {
            return 1;
        }

        return 0;
    }

    private long getScore(Recipe recipe) {
        long sum = 0;

        //todo: sort by relative value, not absolute
        for (MustHaves mustHave : mustHaves) {
            sum += recipe.getMustHaves().get(mustHave);
        }

        return sum / (long) mustHaves.size();
    }
}
