package com.example.nutrime;

import android.media.Image;

public class CreateRecipes {

    public CreateRecipes() {
    }

    public Recipe[] create() {
        Properties properties = new Properties(false, false, true, false, true, false, true, false);

        Recipe recipe1 = new Recipe("Paprika-Gulasch", R.mipmap.gulasch_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 4, 1.5);
        Recipe recipe2 = new Recipe("Pfirsichsalat", R.mipmap.pfirsichsalat_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 2, 1.5);
        Recipe recipe3 = new Recipe("Kiwi-Mango Smoothie Bowl", R.mipmap.kiwi_bowl_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 1, 1.5);

        return new Recipe[] {recipe1, recipe2, recipe3};
    }
}
