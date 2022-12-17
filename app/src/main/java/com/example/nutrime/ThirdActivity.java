package com.example.nutrime;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutrime.enums.MustHaves;

import java.util.List;
import java.util.Map;

public class ThirdActivity extends AppCompatActivity {

    CreateRecipes recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        recipes = CreateRecipes.getInstance();

        String name = getIntent().getStringExtra("REZEPT_name");
        System.out.println(name);

        Recipe recipe = recipes.getRecipeName(name);

        int rating = recipe.getRating();

        ImageView spoon1 =  findViewById(R.id.img_spoon1);
        ImageView spoon2 =  findViewById(R.id.img_spoon2);
        ImageView spoon3 =  findViewById(R.id.img_spoon3);
        ImageView spoon4 =  findViewById(R.id.img_spoon4);
        ImageView spoon5 =  findViewById(R.id.img_spoon5);

        spoon1.setImageResource( R.mipmap.spoon_filled_foreground);
        spoon2.setImageResource(R.mipmap.spoon_empty_foreground);
        spoon3.setImageResource(R.mipmap.spoon_empty_foreground);
        spoon4.setImageResource( R.mipmap.spoon_empty_foreground);
        spoon5.setImageResource( R.mipmap.spoon_empty_foreground);
        if (rating > 1) {
            spoon2.setImageResource(R.mipmap.spoon_filled_foreground);
            spoon3.setImageResource(R.mipmap.spoon_empty_foreground);
            spoon4.setImageResource( R.mipmap.spoon_empty_foreground);
            spoon5.setImageResource( R.mipmap.spoon_empty_foreground);
        }
        if (rating > 2) {
            spoon3.setImageResource(R.mipmap.spoon_filled_foreground);
            spoon4.setImageResource( R.mipmap.spoon_empty_foreground);
            spoon5.setImageResource( R.mipmap.spoon_empty_foreground);
        }
        if (rating > 3) {
            spoon4.setImageResource(R.mipmap.spoon_filled_foreground);
            spoon5.setImageResource( R.mipmap.spoon_empty_foreground);
        }
        if (rating > 4) {
            spoon5.setImageResource(R.mipmap.spoon_filled_foreground);
        }

        ImageView picture = findViewById(R.id.iv_rezept_bild);
        picture.setImageResource( recipe.getPicture());

        TextView header = findViewById(R.id.tv_rezept_name);
        header.setText(recipe.getName());


        List ingredients =  recipe.getIngredients();
        LinearLayout linearLayout_name = (LinearLayout) findViewById(R.id.ll_ingredients_name);
        LinearLayout linearLayout_amount = (LinearLayout) findViewById(R.id.ll_ingredients_amount);
        LinearLayout linearLayout_points = (LinearLayout) findViewById(R.id.ll_ingredients_points);

        for( int i = 0; i < ingredients.size(); i++ )
        {
            String[] temp = (String[]) ingredients.get(i);

            TextView textView_name = new TextView(this);
            textView_name.setText(temp[0]);
            linearLayout_name.addView(textView_name);

            TextView textView_amount = new TextView(this);
            textView_amount.setText(temp[1]);
            linearLayout_amount.addView(textView_amount);

            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.ic_launcher_background);
            linearLayout_points.addView(point);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(80,0,0,10);
            textView_name.setLayoutParams(params);
            textView_amount.setLayoutParams(params);

            textView_name.setTextColor(Color.parseColor("#000000"));
            textView_amount.setTextColor(Color.parseColor("#000000"));

            LinearLayout.LayoutParams params_points = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params_points.setMargins(40,20,0,23);
            params_points.height = 20;

            point.setLayoutParams(params_points);
        }

        String[] description = recipe.getDescription();
        LinearLayout linearLayout_description_text = (LinearLayout) findViewById(R.id.ll_description_text);

        for(int i = 0; i<description.length; i++){
            TextView textView = new TextView(this);
            textView.setText(description[i]);
            linearLayout_description_text.addView(textView);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20,0,20,50);
            textView.setLayoutParams(params);

            textView.setTextColor(Color.parseColor("#000000"));

        }

        String time = recipe.getPreparationTimePrettyPrint();
        TextView time_tv =  findViewById(R.id.tv_duration);
        time_tv.setText(time);
        time_tv.setTextColor(Color.parseColor("#000000"));

        Map<MustHaves,Float> must_haves = recipe.getMustHaves();

        LinearLayout linearLayout_nutrients = (LinearLayout) findViewById(R.id.ll_nutrients_column1);
        LinearLayout linearLayout_nutrients_amount = (LinearLayout) findViewById(R.id.ll_nutrients_column2);
        LinearLayout linearLayout_nutrients_percent = (LinearLayout) findViewById(R.id.ll_nutrients_column3);

        for (Map.Entry<MustHaves, Float> entry : must_haves.entrySet()) {
                String key = entry.getKey().toString();

                TextView textView = new TextView(this);
                textView.setText(key);
                textView.setTextSize(14);
                textView.setTextColor(Color.parseColor("#000000"));
                textView.setPadding(20, 20, 20, 20);
                linearLayout_nutrients.addView(textView);

                String val =  String.valueOf(entry.getValue());

                TextView textView1 = new TextView(this);
                textView1.setText(val + " mg");
                textView1.setTextSize(14);
                textView1.setTextColor(Color.parseColor("#000000"));
                textView1.setPadding(20, 20, 20, 20);
                linearLayout_nutrients_amount.addView(textView1);

                TextView textView2 = new TextView(this);
                textView2.setText("= 100%");
                textView2.setTextSize(14);
                textView2.setTextColor(Color.parseColor("#000000"));
                textView2.setPadding(20, 20, 20, 20);
                linearLayout_nutrients_percent.addView(textView2);
        }
    }

    public void showLayout(View view){

        LinearLayout linearLayout_nutrients = (LinearLayout) findViewById(R.id.ll_nutrients);

        if(linearLayout_nutrients.getVisibility()== View.GONE) {
            linearLayout_nutrients.animate()
                    .translationY(70)
                    .alpha(1.0f)
                    .setDuration(400);
            linearLayout_nutrients.setVisibility(View.VISIBLE);
        }
        else {
            linearLayout_nutrients.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setDuration(400);
            linearLayout_nutrients.setVisibility(View.GONE);
        }
    }
}