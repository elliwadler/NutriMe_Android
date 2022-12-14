package com.example.nutrime;

import android.media.Image;
import android.os.Bundle;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
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
        ingredients.add(new String[]{"Olivenöl","5 Esslöffel"});
        ingredients.add(new String[]{"Gemüsebrühe","250 ml"});
        ingredients.add(new String[]{"Paprikapulver","1 Esslöffel"});
        ingredients.add(new String[]{"Kümmel","1/2 Esslöffel"});
        ingredients.add(new String[]{"Tomatenmark","4 Esslöffel"});
        ingredients.add(new String[]{"Petersilie","etwas"});

        String[] description = {
                "Paprika waschen, entkernen, grob würfeln. Zwiebeln schälen und in Streifen oder Ringe schneiden. Knoblauchzehen schälen und sehr fein hacken. Tomaten zerkleinern. Gulasch-Fleisch in zirka 3 cm große Würfel schneiden."
                , "Ofen auf 200 Grad Ober/Unterhitze vorheizen. In der Zwischenzeit das Öl in einer großen Pfanne stark erhitzen. Zwiebeln, Knoblauch und kurz danach das Fleisch scharf darin anbraten und mit der Gemüsebrühe ablöschen. Paprika, Tomaten, Tomatenmark, Salz, Paprikagewürz und Kümmel hinzufügen."
                , "Gulasch im heißen Ofen auf der untersten Schiene zirka 2 Stunden schmoren lassen. Das Gulaschfleisch ist fertig, wenn es sich mit einem Löffel oder zwei Gabeln ohne Widerstand zerteilen lässt. Sauce evtl. mit Salz, Pfeffer, Chilli nachwürzen."};

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
