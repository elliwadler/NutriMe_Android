package com.example.nutrime.dal;

import android.content.res.AssetManager;

import com.example.nutrime.Products;
import com.example.nutrime.Recipe;
import com.example.nutrime.enums.MustHaves;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {

    private static ProductDatabase productDatabase;
    private List<Products> products_list;

    private ProductDatabase(AssetManager assetManager) {
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(assetManager.open("products.json"), StandardCharsets.UTF_8);
            products_list = gson.fromJson(reader, new TypeToken<ArrayList<Products>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Init(AssetManager assetManager)
    {
        productDatabase = new ProductDatabase(assetManager);
    }

    public static ProductDatabase getInstance()
    {
        return productDatabase;
    }

    public List<Products> getProducts()
    {
        return products_list;
    }

    public Products getSpecificProductList(String nutrient){
        Products products = new Products();
        for (Products p : products_list) {
            if (p.getNutrient().toString().equals(nutrient)){
                products = p;
                break;
            }
        }

        return products;
    }
}
