package com.example.nutrime;

import android.media.Image;

public class CreateRecipes {

    public CreateRecipes() {
    }

    public Recipe[] create() {
        Properties properties = new Properties(false, false, true, false, true, false, true, false);

        Recipe recipe1 = new Recipe("Rezept1", null, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 2, 1.5);
        Recipe recipe2 = new Recipe("Rezept2", null, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 3, 1.5);
        Recipe recipe3 = new Recipe("Rezept3", null, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 6, 1.5);

        return new Recipe[] {recipe1, recipe2, recipe3};
    }
}
