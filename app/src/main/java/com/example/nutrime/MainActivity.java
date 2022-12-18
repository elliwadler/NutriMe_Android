package com.example.nutrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nutrime.dal.DailyNeedsDatabase;
import com.example.nutrime.dal.RecipeDatabase;
import com.example.nutrime.enums.MustHaves;
import com.example.nutrime.enums.NoGos;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Recipe recipeOfTheDay;
    private boolean searchIsHidden = true;
    private final int searchWindowDifference = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeDatabase.init(getAssets());
        DailyNeedsDatabase.init(getAssets());

        recipeOfTheDay = RecipeDatabase.getInstance().getRecipeOfTheDay();
    }

    public Recipe getRecipeOfTheDay() {
        return recipeOfTheDay;
    }

    public void switchSearch(View view) {
        if (searchIsHidden) {
            findViewById(R.id.fragmentContainerStartpage).animate()
                    .translationY(searchWindowDifference)
                    .alpha(1.0f)
                    .setDuration(400);
        }
        else {
            findViewById(R.id.fragmentContainerStartpage).animate()
                    .translationY(0)
                    .alpha(1.0f)
                    .setDuration(400);
        }
        searchIsHidden = !searchIsHidden;
    }

    public void onSearch(View view)
    {
        List<MustHaves> mustHaves = getMustHaves();
        List<NoGos> noGos = getNoGos();

        List<Recipe> sortedRecipes = RecipeDatabase.getInstance().getExcludedAndSortedRecipes(noGos,  mustHaves);

        Gson gson = new Gson();

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        //It is hard to put enums and list of custom types, so I just serialize everything to String
        intent.putExtra("mustHavesList", gson.toJson(mustHaves));
        intent.putExtra("noGosList", gson.toJson(noGos));
        intent.putExtra("sortedRecipesList", gson.toJson(sortedRecipes));
        startActivity(intent);
    }

    @NonNull
    private List<MustHaves> getMustHaves() {
        List<MustHaves> mustHaves = new ArrayList<>();
        if ( ((CheckBox)findViewById(R.id.checkBoxEisen)).isChecked() ) {
            mustHaves.add(MustHaves.Eisen);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxMagnesium)).isChecked() ) {
            mustHaves.add(MustHaves.Magnesium);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxKalium)).isChecked() ) {
            mustHaves.add(MustHaves.Kalium);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxCalcium)).isChecked() ) {
            mustHaves.add(MustHaves.Calcium);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxSelen)).isChecked() ) {
            mustHaves.add(MustHaves.Selen);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxAntioxidantien)).isChecked() ) {
            mustHaves.add(MustHaves.Antioxidantien);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxOmega3)).isChecked() ) {
            mustHaves.add(MustHaves.Omega3);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxNatrium)).isChecked() ) {
            mustHaves.add(MustHaves.Natrium);
        }
        return mustHaves;
    }

    private List<NoGos> getNoGos()
    {
        List<NoGos> noGos= new ArrayList<>();
        if ( ((CheckBox)findViewById(R.id.checkBoxGluten)).isChecked() ) {
            noGos.add(NoGos.Gluten);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxFruktose)).isChecked() ) {
            noGos.add(NoGos.Fruktose);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxSoja)).isChecked() ) {
            noGos.add(NoGos.Sojabohnen);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxLaktose)).isChecked() ) {
            noGos.add(NoGos.Laktose);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxNuesse)).isChecked() ) {
            noGos.add(NoGos.Nuesse);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxSellerie)).isChecked() ) {
            noGos.add(NoGos.Sellerie);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxSchalenfruechte)).isChecked() ) {
            noGos.add(NoGos.Schalenfruechte);
        }
        if ( ((CheckBox)findViewById(R.id.checkBoxEier)).isChecked() ) {
            noGos.add(NoGos.Eier);
        }

        int tabPosition = ((TabLayout)findViewById((R.id.tabLayoutDiet))).getSelectedTabPosition();
        if (tabPosition == 1) {
            noGos.add(NoGos.Tier);
        }
        else if (tabPosition == 2) {
            noGos.add(NoGos.Tierprodukt);
        }

        return noGos;
    }

    public void goToRecipe(View view) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("REZEPT_name", recipeOfTheDay.getName());
        CreateRecipes.getInstance().init(Collections.singletonList(recipeOfTheDay));
        startActivity(intent);
    }
}