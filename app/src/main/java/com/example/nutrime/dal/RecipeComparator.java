package com.example.nutrime.dal;

import com.example.nutrime.Recipe;
import com.example.nutrime.enums.MustHaves;

import java.util.List;

public class RecipeComparator implements java.util.Comparator<Recipe> {

    private final List<MustHaves> mustHaves;

    public RecipeComparator(List<MustHaves> mustHaves) {
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

    private Float getScore(Recipe recipe) {
        float sum = 0;
        DailyNeedsDatabase dailyNeeds = DailyNeedsDatabase.getInstance();

        for (MustHaves mustHave : mustHaves) {
            Float absoluteValue = recipe.getMustHaves().get(mustHave);
            sum += dailyNeeds.getRelativeAmount(mustHave, absoluteValue);
        }

        return sum / mustHaves.size();
    }
}
