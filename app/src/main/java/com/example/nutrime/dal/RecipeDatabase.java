package com.example.nutrime.dal;

import android.content.res.AssetManager;

import com.example.nutrime.Recipe;
import com.example.nutrime.enums.MustHaves;
import com.example.nutrime.enums.NoGos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeDatabase {

    private static RecipeDatabase recipeDatabase;
    private List<Recipe> recipes;

    private RecipeDatabase(AssetManager assetManager) {
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(assetManager.open("recipes.json"), StandardCharsets.UTF_8);
            recipes = gson.fromJson(reader, new TypeToken<ArrayList<Recipe>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(AssetManager assetManager)
    {
        recipeDatabase = new RecipeDatabase(assetManager);
    }

    public static RecipeDatabase getInstance()
    {
        return recipeDatabase;
    }

    public List<Recipe> getRecipes()
    {
        return recipes;
    }

    public List<Recipe> getExcludedAndSortedRecipes(List<NoGos> noGos, List<MustHaves> mustHaves)
    {
        return recipes.stream().filter(e -> {
            for (NoGos noGo : noGos) {
                if (Boolean.TRUE.equals(e.getNoGos().get(noGo))) {
                    return false;
                }
            }
            return true;
        }).sorted(new Comparator(mustHaves)).collect(Collectors.toList());
    }

    public Recipe getRecipeOfTheDay() {
        return recipes.get((int) (Math.random() * recipes.size()) );
    }
}
