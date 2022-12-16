package com.example.nutrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutrime.dal.RecipeDatabase;
import com.example.nutrime.enums.MustHaves;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean isHidden = true;
    private int searchWindowDifference = 1430;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeDatabase.Init(getAssets());
    }

    public void switchSearch(View view) {
        if (isHidden) {
            findViewById(R.id.fragmentContainerSearch).setY(findViewById(R.id.fragmentContainerSearch).getY() + searchWindowDifference);
        }
        else {
            findViewById(R.id.fragmentContainerSearch).setY(findViewById(R.id.fragmentContainerSearch).getY() - searchWindowDifference);
        }
        isHidden = !isHidden;
    }

    public void onSearch(View view)
    {
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

        List<Recipe> sortedRecipes = RecipeDatabase.getInstance().getSortedRecipes(mustHaves);

        Gson gson = new Gson();

        System.out.println(mustHaves.get(0));

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        //It is hard to put enums and list of custom types, so I just serialize everything to String
        intent.putExtra("mustHavesList", gson.toJson(mustHaves));
        intent.putExtra("sortedRecipesList", gson.toJson(sortedRecipes));
        startActivity(intent);
    }
}