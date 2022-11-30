package com.example.nutrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        CreateRecipes recipes = new CreateRecipes();

        String recipe_name_List[] = recipes.getNames();
        String recipe_rating_List[] = recipes.getRating();
        int recipe_picture_List[] = recipes.getPictures();
        String recipe_time_List[] = recipes.getTime();

        ArrayList<String[]> recipe_properties_List = recipes.getProperties();

        TextView tv = findViewById(R.id.tv_recipes_header);
        tv.setText("Rezepte");

        ListView simpleList;

        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), recipe_name_List, recipe_rating_List, recipe_picture_List, recipe_properties_List, recipe_time_List);
            simpleList.setAdapter(customAdapter);

        ListView lv_item= findViewById(R.id.simpleListView);

        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("clicked "+position);
                String name = recipes.getRecipe(position).getName();


                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("REZEPT_name",name);

                startActivity(intent);
            }
        });
    }
}