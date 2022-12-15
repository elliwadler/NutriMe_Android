package com.example.nutrime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import com.example.nutrime.R;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    private boolean isHidden = true;
    private int searchWindowDifference = 1430;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("target/recipe.json"),new test(1,2));
            System.out.println("test");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public void switchScreen(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void switchSearch(View view) {
        if (isHidden) {
            findViewById(R.id.fragmentContainerView4).setY(findViewById(R.id.fragmentContainerView4).getY() + searchWindowDifference);
        }
        else {
            findViewById(R.id.fragmentContainerView4).setY(findViewById(R.id.fragmentContainerView4).getY() - searchWindowDifference);
        }
        isHidden = !isHidden;
    }
}