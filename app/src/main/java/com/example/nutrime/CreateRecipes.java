package com.example.nutrime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateRecipes {

    Recipe recipes[];
    public static CreateRecipes instance = new CreateRecipes();

    private CreateRecipes() {
    }

    public void init(List<Recipe> sortedRecipes) {
        recipes = sortedRecipes.toArray(new Recipe[0]);
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

            // Getting the highest 3 nutrients from the must haves
            // todo: convert to relative value first, sorting by absolute makes no sense
            // idea: create conversion class which takes nutrient enum and absolut value, then returns relative value
            properties[i] = new ArrayList(recipes[i].getMustHaves().entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(e -> e.getKey().toString())
                    .collect(Collectors.toList()));
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
