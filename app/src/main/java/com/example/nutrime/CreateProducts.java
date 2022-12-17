package com.example.nutrime;

import com.example.nutrime.enums.MustHaves;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CreateProducts {

    ArrayList<Products> products;
    public static CreateProducts instance = new CreateProducts();

    private CreateProducts() {
        products = new ArrayList<>();
    }

    public static CreateProducts getInstance() {
        if (instance == null) {
            instance = new CreateProducts();
        }
        return instance;
    }

    public void load(){
        ArrayList<String> should_eat = new ArrayList<>(Arrays.asList("Rindfleisch","Sesam","Pistazien","Spinat","Haferflocken","Cashewkerne"));
        ArrayList<String> should_not_eat = new ArrayList<>(Arrays.asList("Rotwein","schwarzer Tee","Kakao","rote Beete","Reisen"));
        ArrayList<String> help = new ArrayList<>(Arrays.asList("Kiwis", "Paprika", "Zitrusfrüchte", "Brokkoli"));

        Products eisen = new Products(MustHaves.Eisen, should_eat, should_not_eat, help);

        this.products.add(eisen);

        should_eat = new ArrayList<>(Arrays.asList("Kürbiskerne","Weizenkleie","Weizenkleie","Mandeln","Sojabohnen","Mais", "Kichererbsen","Banane"));
        should_not_eat = new ArrayList<>(Arrays.asList("Rotwein","schwarzer Tee","Kakao","rote Beete","Reisen"));
        help = new ArrayList<>(Arrays.asList("Kiwis","Paprika","Zitrusfrüchte","Brokkoli"));
        Products magnesium = new Products(MustHaves.Magnesium, should_eat, should_not_eat, help);

        this.products.add(magnesium);

        should_eat = new ArrayList<>(Arrays.asList("Bananan","Karotten","Avocado","Mandeln","Zartbitterschokolade","Dinkelmehl", "Forelle"));
        should_not_eat = new ArrayList<>(Arrays.asList("Rotwein","schwarzer Tee","Kakao","rote Beete","Reisen"));
        help = new ArrayList<>(Arrays.asList("Olivenöl"));
        Products kalium = new Products(MustHaves.Kalium, should_eat, should_not_eat, help);

        this.products.add(kalium);

        should_eat = new ArrayList<>(Arrays.asList("Fisch","Haferflocken","Ei","Milchprodukte","Mineralwasser","Hülsenfrüchte"));
        should_not_eat = new ArrayList<>(Arrays.asList("Alkohol","Kaffe","Salz"));
        help = new ArrayList<>(Arrays.asList(""));
        Products calcium = new Products(MustHaves.Calcium, should_eat, should_not_eat, help);

        this.products.add(calcium);

        should_eat = new ArrayList<>(Arrays.asList("Hafer","Kakao","Paprika","Tofu","Leinsamen","Paranüsse","Champignons","Brokkoli"));
        should_not_eat = new ArrayList<>(Arrays.asList(""));
        help = new ArrayList<>(Arrays.asList(""));
        Products selen = new Products(MustHaves.Selen, should_eat, should_not_eat, help);

        this.products.add(selen);

        should_eat = new ArrayList<>(Arrays.asList("Äpfel","Kaffee","Knoblauch","Tomaten","Hirse","Paranüsse","Brokkoli"));
        should_not_eat = new ArrayList<>(Arrays.asList(""));
        help = new ArrayList<>(Arrays.asList(""));
        Products antioxidantien = new Products(MustHaves.Antioxidantien, should_eat, should_not_eat, help);

        this.products.add(antioxidantien);


        should_eat = new ArrayList<>(Arrays.asList("Leinöl","Chiasamen","Walnüsse","Hering","Lachs","Thunfisch"));
        should_not_eat = new ArrayList<>(Arrays.asList(""));
        help = new ArrayList<>(Arrays.asList(""));
        Products omega3 = new Products(MustHaves.Omega3, should_eat, should_not_eat, help);

        this.products.add(omega3);

        should_eat = new ArrayList<>(Arrays.asList("Mozzerella","Schafskäse","Kastanien","Oliven","Salzstangen","Salami"));
        should_not_eat = new ArrayList<>(Arrays.asList(""));
        help = new ArrayList<>(Arrays.asList(""));
        Products natrium = new Products(MustHaves.Natrium, should_eat, should_not_eat, help);

        this.products.add(natrium);

      //  Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Type listType = new TypeToken<List<Products>>() {}.getType();

        Gson gson = new Gson();
        String json = gson.toJson(products, listType);
        List<String> target2 = gson.fromJson(json, listType);


        System.out.println(json);
    }

}
