package com.example.nutrime;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String name = getIntent().getStringExtra("REZEPT_name");
        System.out.println(name);

        CreateRecipes createRecipes = new CreateRecipes();
        Recipe recipe = createRecipes.getRecipeName(name);


        TextView tv_recipe = (TextView) findViewById(R.id.tv_rezept);
        tv_recipe.setText(recipe.toString());
    }
}