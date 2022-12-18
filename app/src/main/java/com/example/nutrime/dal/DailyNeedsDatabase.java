package com.example.nutrime.dal;

import android.content.res.AssetManager;

import com.example.nutrime.Products;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class DailyNeedsDatabase {

    private static DailyNeedsDatabase dailyNeedsDatabase;
    private HashMap needs_list;

    private DailyNeedsDatabase(AssetManager assetManager) {
        needs_list = new HashMap<>();
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(assetManager.open("DailyDosis.json"), StandardCharsets.UTF_8);
            needs_list = gson.fromJson(reader, new TypeToken<HashMap<String,Double>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Init(AssetManager assetManager)
    {
        dailyNeedsDatabase = new DailyNeedsDatabase(assetManager);
    }

    public static DailyNeedsDatabase getInstance()
    {
        return dailyNeedsDatabase;
    }

    public HashMap getMap()
    {
        return needs_list;
    }

}
