package com.example.nutrime;

import android.media.Image;
import android.os.Bundle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateRecipes {

    Recipe recipes[];

    public CreateRecipes() {
       this.recipes = this.load();
    }

    private Recipe[] load() {
        Properties properties = new Properties(false, false, true, false, true, false, true, false);

        Recipe recipe1 = new Recipe("Paprika-Gulasch", R.mipmap.gulasch_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 4, 100);
        Recipe recipe2 = new Recipe("Pfirsichsalat", R.mipmap.pfirsichsalat_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 2, 20);
        Recipe recipe3 = new Recipe("Kiwi-Mango Smoothie Bowl", R.mipmap.pfirsichsalat_foreground, new String[]{"Schritt1", "Schritt2", "Schritt3"},
                properties, 1, 300);

        return new Recipe[] {recipe1, recipe2, recipe3};
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
            String output ="";
            long h = recipes[i].getDuration() / 60;
            long m = recipes[i].getDuration() % 60;

            if(h != 0 && m!=0)
                output = h+" Std. "+m+" Min.";
            else if(h == 0 && m!=0)
                output = m+" Min.";
            else
                output = h+" Std. ";

            time_string[i] = output;
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
