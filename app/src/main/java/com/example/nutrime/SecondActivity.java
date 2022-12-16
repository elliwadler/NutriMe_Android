package com.example.nutrime;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    CreateRecipes recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recipes = CreateRecipes.getInstance();

        LoadDataInListView();

        ListView lv_item = findViewById(R.id.simpleListView);

        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchScreen(position);
            }
        });

        LinearLayout linearLayout_name = (LinearLayout) findViewById(R.id.searchresult_yellow);

        TextView textView_kind = new TextView(this);
        textView_kind.setText("Vegetarisch");
        textView_kind.setTextSize(14);
        textView_kind.setBackgroundColor(getResources().getColor(R.color.bg_rounded_yellow_background));
        textView_kind.setPadding(20, 20, 20, 20);
        linearLayout_name.addView(textView_kind);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        textView_kind.setLayoutParams(params);

        LinearLayout linearLayout_no_origin = (LinearLayout) findViewById(R.id.searchresult_red);

        LinearLayout linearLayout_no = new LinearLayout(this);
        linearLayout_no.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_no_origin.addView(linearLayout_no);

        LinearLayout linearLayout_no1 = new LinearLayout(this);
        linearLayout_no1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_no_origin.addView(linearLayout_no1);

        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                TextView textView_no = new TextView(this);
                textView_no.setText("Nüsse");
                textView_no.setTextSize(14);
                textView_no.setBackgroundColor(getResources().getColor(R.color.bg_rounded_red_background));
                textView_no.setPadding(20, 20, 20, 20);
                linearLayout_no.addView(textView_no);
                textView_no.setLayoutParams(params);
            }
            if (i >= 4) {

                TextView textView_no1 = new TextView(this);
                textView_no1.setText("Nüsse");
                textView_no1.setTextSize(14);
                textView_no1.setBackgroundColor(getResources().getColor(R.color.bg_rounded_red_background));
                textView_no1.setPadding(20, 20, 20, 20);
                linearLayout_no1.addView(textView_no1);
                textView_no1.setLayoutParams(params);
            }
        }

        LinearLayout linearLayout_yes_origin = (LinearLayout) findViewById(R.id.searchresult_green);

        LinearLayout linearLayout_yes = new LinearLayout(this);
        linearLayout_yes.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_yes_origin.addView(linearLayout_yes);

        LinearLayout linearLayout_yes1 = new LinearLayout(this);
        linearLayout_yes1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_yes_origin.addView(linearLayout_yes1);

        for (int i = 0; i <4 ; i++) {
            if (i < 4) {
                TextView textView_yes = new TextView(this);
                textView_yes.setText("Eisen");
                textView_yes.setTextSize(14);
                textView_yes.setClickable(true);
                int finalI = i;
                textView_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout linearLayout_food = (LinearLayout) findViewById(R.id.ll_food);

                        if(linearLayout_food.getVisibility()== View.GONE) {
                            linearLayout_food.animate()
                                    .translationY(70)
                                    .alpha(1.0f)
                                    .setDuration(400);
                            linearLayout_food.setVisibility(View.VISIBLE);
                        }
                        else {
                            linearLayout_food.animate()
                                    .translationY(0)
                                    .alpha(0.0f)
                                    .setDuration(400);
                            linearLayout_food.setVisibility(View.GONE);
                        }
                    }
                });
                textView_yes.setBackgroundColor(getResources().getColor(R.color.bg_rounded_green_background));
                textView_yes.setPadding(20, 20, 20, 20);
                linearLayout_yes.addView(textView_yes);
                textView_yes.setLayoutParams(params);
            }
        }

     /*     <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="15dp"
        android:background="@color/green"
        android:orientation="horizontal">

        <android.widget.Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="40dp"
        android:backgroundTint="@color/green"
        android:text="Nähwerte"
        android:textSize="16dp"
        android:shadowRadius="0"
        android:onClick="showLayout"
                />

        <ImageButton
        android:id="@+id/imageButton"
        android:layout_width="25dp"
        android:layout_height="match_parent"
        android:backgroundTint="@color/green"
        android:onClick="showLayout"
        android:src="@drawable/bg_arrow_foreground" />

    </LinearLayout>*/
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