package com.example.nutrime;

import android.media.Image;
import android.os.Bundle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateRecipes {

    Recipe recipes[];
    public static CreateRecipes instance = new CreateRecipes();

    private CreateRecipes() {
       this.recipes = this.load();
    }

    private Recipe[] load() {
        List<String[]> ingredients = new ArrayList<String[]>();
        ingredients.add(new String[]{"Rinderfleisch","750 Gramm"});
        ingredients.add(new String[]{"Paprikaschoten","4 Stück"});
        ingredients.add(new String[]{"Zwiebeln","3 Stück"});
        ingredients.add(new String[]{"Knoblauchzehen","2 Stück"});
        ingredients.add(new String[]{"Tomaten","4 Stück"});

        String[] description = {
                "step1 -Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
                , "step2 - Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
                , "step3 - Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."};

        Properties properties = new Properties(false, false, true, false, true, false, true, false);

        Recipe recipe1 = new Recipe("Paprika-Gulasch", R.mipmap.gulasch_foreground, description,
                properties, 4, 100, ingredients);
        Recipe recipe2 = new Recipe("Pfirsichsalat", R.mipmap.pfirsichsalat_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 2, 20, ingredients);
        Recipe recipe3 = new Recipe("Kiwi-Mango Smoothie Bowl", R.mipmap.kiwi_bowl_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 1, 300, ingredients);

        return new Recipe[] {recipe1, recipe2, recipe3};
    }

    public static CreateRecipes getInstance() {
        if (instance == null) {
            instance = new CreateRecipes();
        }
        return instance;
    }



    public int[] getPictures(){
        int pictures[] = new int[this.recipes.length];
        for (int i = 0; i<recipes.length;i++) {
            pictures[i] = recipes[i].getPicture();
        }
        return pictures;
    }

    public String[] getNames(){
        String names[] = new String[this.recipes.length];
        for (int i = 0; i<recipes.length;i++) {
            names[i] = recipes[i].getName();
        }
        return names;
    }

    public String[] getRating(){
        String rating[] = new String[this.recipes.length];
        for (int i = 0; i<recipes.length;i++) {
            rating[i] = String.valueOf(recipes[i].getRating());
        }
        return rating;
    }
    public String[] getTime(){
        String time_string[] = new String[this.recipes.length];
        for (int i = 0; i<recipes.length;i++) {
            time_string[i] = recipes[i].getDuration();
        }
        return time_string;
    }
    public ArrayList<String[]> getProperties(){
        ArrayList properties[] = new ArrayList[recipes.length];
        String array[] = new String[this.recipes.length];
        ArrayList<String[]> all = new ArrayList<>();
        for (int i = 0; i<recipes.length;i++) {
            properties[i] = recipes[i].getProperties().getTrue();
            array = (String[]) properties[i].toArray(new String[properties[i].size()]);
            all.add(array);
        }
        return all;

    }

    public Recipe getRecipe(int id){
        return recipes[id];
    }

    public Recipe getRecipeName(String name){
        for(int i = 0; i< recipes.length;i++) {
            if(recipes[i].getName().equals(name)){
                return recipes[i];
            }
        }
        return null;
    }
}
