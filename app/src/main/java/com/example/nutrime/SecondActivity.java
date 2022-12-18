package com.example.nutrime;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutrime.dal.ProductDatabase;
import com.example.nutrime.enums.MustHaves;
import com.example.nutrime.enums.NoGos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    CreateRecipes recipes;
    public int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //delete later
        // CreateProducts createProducts = CreateProducts.getInstance();
        //createProducts.load();

        Gson gson = new Gson();
        Intent intent = getIntent();
        List<MustHaves> mustHaves = gson.fromJson(intent.getStringExtra("mustHavesList"), new TypeToken<ArrayList<MustHaves>>() {
        }.getType());
        List<NoGos> noGos = gson.fromJson(intent.getStringExtra("noGosList"), new TypeToken<ArrayList<NoGos>>() {
        }.getType());
        List<Recipe> sortedRecipes = gson.fromJson(intent.getStringExtra("sortedRecipesList"), new TypeToken<ArrayList<Recipe>>() {
        }.getType());

        recipes = CreateRecipes.getInstance();
        recipes.init(sortedRecipes);

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

        if (noGos.contains(NoGos.Tier)) {
            textView_kind.setText("Vegetarisch");
        } else if (noGos.contains(NoGos.Tierprodukt)) {
            textView_kind.setText("Vegan");
        } else {
            textView_kind.setText("Alles");
        }
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

        for (int i = 0; i < noGos.size(); i++) {
            String name = noGos.get(i).toString();
            TextView textView_no = new TextView(this);
            textView_no.setText(name);
            textView_no.setTextSize(14);
            textView_no.setBackgroundColor(getResources().getColor(R.color.bg_rounded_red_background));
            textView_no.setPadding(20, 20, 20, 20);
            if (i < 4) {
                linearLayout_no.addView(textView_no);
            }
            if (i >= 4) {
                linearLayout_no1.addView(textView_no);
            }
            textView_no.setLayoutParams(params);

        }

        LinearLayout linearLayout_yes_origin = (LinearLayout) findViewById(R.id.searchresult_green);

        LinearLayout linearLayout_yes = new LinearLayout(this);
        linearLayout_yes.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_yes_origin.addView(linearLayout_yes);

        LinearLayout linearLayout_yes1 = new LinearLayout(this);
        linearLayout_yes1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout_yes_origin.addView(linearLayout_yes1);

        for (int i = 0; i < mustHaves.size(); i++) {

            String name = mustHaves.get(i).toString();
            TextView textView_yes = new TextView(this);
            textView_yes.setText(name);
            textView_yes.setTextSize(14);
            textView_yes.setClickable(true);
            number = i;
            textView_yes.setOnClickListener(this::onClick);
            textView_yes.setBackgroundColor(getResources().getColor(R.color.bg_rounded_green_background));
            textView_yes.setPadding(20, 20, 20, 20);

            textView_yes.setId(getIDButton(name));

            if (i < 4) {
                linearLayout_yes.addView(textView_yes);
            }
            if (i >= 4) {
                linearLayout_yes1.addView(textView_yes);
            }
            textView_yes.setLayoutParams(params);
        }
    }

    public void switchScreen(int position) {
        String name = recipes.getRecipe(position).getName();
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("REZEPT_name", name);

        startActivity(intent);
    }

    public void LoadDataInListView() {
        String[] recipe_name_List = recipes.getNames();
        String[] recipe_rating_List = recipes.getRating();
        int[] recipe_picture_List = recipes.getPictures();
        String[] recipe_time_List = recipes.getTime();

        ArrayList<String[]> recipe_properties_List = recipes.getProperties();

        TextView tv = findViewById(R.id.tv_recipes_header);
        tv.setText("Rezepte");

        ListView simpleList;

        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), recipe_name_List, recipe_rating_List, recipe_picture_List, recipe_properties_List, recipe_time_List);
        simpleList.setAdapter(customAdapter);
    }

    public int getIDButton(String name) {
        int id = 0;
        switch (name) {
            case ("Eisen"):
                id = 0;
                break;
            case ("Magnesium"):
                id = 1;
                break;
            case ("Kalium"):
                id = 2;
                break;
            case ("Calcium"):
                id = 3;
                break;
            case ("Selen"):
                id = 4;
                break;
            case ("Antioxidantien"):
                id = 5;
                break;
            case ("Omega3"):
                id = 6;
                break;
            case ("Natrium"):
                id = 7;
                break;
        }
        return id;
    }

    public void onClick(View view) {
        LinearLayout linearLayout_food = (LinearLayout) findViewById(R.id.ll_food);
        linearLayout_food.removeAllViews();

        if (linearLayout_food.getVisibility() == View.GONE) {
            linearLayout_food.animate()
                    .translationY(70)
                    .alpha(1.0f)
                    .setDuration(400);
            linearLayout_food.setVisibility(View.VISIBLE);
        } else {
            linearLayout_food.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setDuration(400);
            linearLayout_food.setVisibility(View.GONE);
        }


        switch (view.getId()) {
            case (0):
                loadProducts("Eisen", linearLayout_food);
                break;
            case (1):
                loadProducts("Magnesium", linearLayout_food);
                break;
            case (2):
                loadProducts("Kalium", linearLayout_food);
                break;
            case (3):
                loadProducts("Calcium", linearLayout_food);
                break;
            case (4):
                loadProducts("Selen", linearLayout_food);
                break;
            case (5):
                loadProducts("Antioxidantien", linearLayout_food);
                break;
            case (6):
                loadProducts("Omega3", linearLayout_food);
                break;
            case (7):
                loadProducts("Natrium", linearLayout_food);
                break;
        }


    }

    public void loadProducts(String nutrient, LinearLayout linearLayout_food) {

        ProductDatabase.Init(getAssets());
        Products products = new Products();
        products = ProductDatabase.getInstance().getSpecificProductList(nutrient);

        //should eat
        TextView textView_header1 = new TextView(this);
        textView_header1.setText(nutrient+"-haltige Lebensmittel");
        textView_header1.setTypeface(textView_header1.getTypeface(), Typeface.BOLD);
        textView_header1.setTextColor(getResources().getColor(R.color.bg_rounded_green_background));
        textView_header1.setTextSize(16);
        textView_header1.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView_header1);

        TextView textView = new TextView(this);
        textView.setText(products.String_should_eat());
        textView.setMaxLines(4);
        textView.setLines(4);
        textView.setTextSize(14);
        textView.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView);

        //shouldn't eat

        TextView textView_header2 = new TextView(this);
        textView_header2.setText("Hemmt Aufnahme");
        textView_header2.setTypeface(textView_header2.getTypeface(), Typeface.BOLD);
        textView_header2.setTextColor(getResources().getColor(R.color.bg_rounded_red_background));
        textView_header2.setTextSize(16);
        textView_header2.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView_header2);

        TextView textView_no = new TextView(this);
        textView_no.setText(products.String_should_not_eat());
        textView_no.setMaxLines(4);
        textView_no.setLines(4);
        textView_no.setTextSize(14);
        textView_no.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView_no);


        //shouldn't eat

        TextView textView_header3 = new TextView(this);
        textView_header3.setText("Fördert Aufnahme");
        textView_header3.setTypeface(textView_header3.getTypeface(), Typeface.BOLD);
        textView_header3.setTextColor(getResources().getColor(R.color.bg_rounded_yellow_background));
        textView_header3.setTextSize(16);
        textView_header3.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView_header3);

        TextView textView_h = new TextView(this);
        textView_h.setText(products.String_help());
        textView_h.setMaxLines(4);
        textView_h.setLines(4);
        textView_h.setTextSize(14);
        textView_h.setPadding(20, 20, 20, 20);
        linearLayout_food.addView(textView_h);


    }
}