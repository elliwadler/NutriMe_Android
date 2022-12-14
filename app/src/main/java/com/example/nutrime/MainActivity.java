package com.example.nutrime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

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
}