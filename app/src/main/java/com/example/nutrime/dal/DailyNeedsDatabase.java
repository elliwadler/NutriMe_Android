package com.example.nutrime.dal;

import android.content.res.AssetManager;

import com.example.nutrime.enums.MustHaves;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DailyNeedsDatabase {

    private static DailyNeedsDatabase dailyNeedsDatabase;
    private HashMap<MustHaves, Float> needs_list;

    private DailyNeedsDatabase(AssetManager assetManager) {
        needs_list = new HashMap<>();
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(assetManager.open("DailyDosis.json"), StandardCharsets.UTF_8);
            needs_list = gson.fromJson(reader, new TypeToken<HashMap<MustHaves,Float>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(AssetManager assetManager)
    {
        dailyNeedsDatabase = new DailyNeedsDatabase(assetManager);
    }

    public static DailyNeedsDatabase getInstance()
    {
        return dailyNeedsDatabase;
    }

    public Float getRelativeAmount(MustHaves name, Float absoluteAmount) {
        return (absoluteAmount / needs_list.get(name)) * 100;
    }
}
