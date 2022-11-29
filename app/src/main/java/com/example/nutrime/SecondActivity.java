package com.example.nutrime;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        CreateRecipes c = new CreateRecipes();
        Recipe recipes[] = c.create();

        TextView tv = findViewById(R.id.tv_recipes_header);
        tv.setText("Rezepte");

        ListView simpleList;
        int flags[] = new int[recipes.length];
        String recipe_Name_List[] = new String[recipes.length];
        String recipe_Rating_List[] = new String[recipes.length];
        for (int i = 0; i<recipes.length;i++)
        {
            recipe_Name_List[i] = recipes[i].getName();
            recipe_Rating_List[i] = String.valueOf(recipes[i].getRating());
            flags[i] = recipes[i].getPicture();
        }



        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), recipe_Name_List, recipe_Rating_List, flags);
            simpleList.setAdapter(customAdapter);

    }
}