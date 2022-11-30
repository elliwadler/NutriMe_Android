package com.example.nutrime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    CreateRecipes recipes = new CreateRecipes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LoadDataInListView();

        ListView lv_item= findViewById(R.id.simpleListView);

        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchScreen(position);
            }
        });
    }
    public void switchScreen(int position){
                String name = recipes.getRecipe(position).getName();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("REZEPT_name",name);

                startActivity(intent);
    }
    public void LoadDataInListView(){
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
    }
}