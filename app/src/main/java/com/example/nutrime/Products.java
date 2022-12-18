package com.example.nutrime;

import android.widget.TextView;

import com.example.nutrime.enums.MustHaves;

import java.util.ArrayList;

public class Products {
    MustHaves nutrient;
    ArrayList<String> should_eat;
    ArrayList<String> should_not_eat;
    ArrayList<String> help;

    public Products(){}

    public Products(MustHaves nutrient, ArrayList<String> should_eat, ArrayList<String> should_not_eat, ArrayList<String> help) {
        this.nutrient = nutrient;
        this.should_eat = should_eat;
        this.should_not_eat = should_not_eat;
        this.help = help;
    }

    public MustHaves getNutrient() {
        return nutrient;
    }

    public void setNutrient(MustHaves nutrient) {
        this.nutrient = nutrient;
    }

    public ArrayList<String> getShould_eat() {
        return should_eat;
    }

    public void setShould_eat(ArrayList<String> should_eat) {
        this.should_eat = should_eat;
    }

    public ArrayList<String> getShould_not_eat() {
        return should_not_eat;
    }

    public void setShould_not_eat(ArrayList<String> should_not_eat) {
        this.should_not_eat = should_not_eat;
    }

    public ArrayList<String> getHelp() {
        return help;
    }

    public void setHelp(ArrayList<String> help) {
        this.help = help;
    }

    public String String_should_eat(){
        String string=should_eat.get(0);
        for (String s : this.should_eat.subList(1,should_eat.size())) {
            string+=", "+s;
        }
        return string;
    }

    public String String_should_not_eat(){
        String string=should_not_eat.get(0);
        for (String s : this.should_not_eat.subList(1,should_not_eat.size())) {
            string+=", "+s;
        }
        return string;
    }

    public String String_help(){
        String string=help.get(0);
        for (String s : this.help.subList(1,help.size())) {
            string+=", "+s;
        }
        return string;
    }
}
