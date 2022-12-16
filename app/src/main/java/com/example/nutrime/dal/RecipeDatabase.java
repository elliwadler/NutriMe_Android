package com.example.nutrime.dal;

import android.content.res.AssetManager;

import com.example.nutrime.Recipe;
import com.example.nutrime.enums.MustHaves;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public static void Init(AssetManager assetManager)
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

    public List<Recipe> getSortedRecipes(List<MustHaves> mustHaves)
    {
        recipes.sort(new Comparator(mustHaves));
        return recipes;
    }
}
