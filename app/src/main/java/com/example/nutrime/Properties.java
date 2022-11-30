package com.example.nutrime;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Properties {

    Map<String, Boolean> must_haves;

    public Properties(boolean eisen, boolean magnesium, boolean kalium, boolean calcium, boolean selen, boolean antioxidantien, boolean omega3, boolean natrium) {
        must_haves = new HashMap<>();
        must_haves.put("Eisen", eisen);
        must_haves.put("Magnesium", magnesium);
        must_haves.put("Kalium", kalium);
        must_haves.put("Calcium", calcium);
        must_haves.put("Selen", selen);
        must_haves.put("Antioxidantien", antioxidantien);
        must_haves.put("Omega-3", omega3);
        must_haves.put("Natrium", natrium);
    }

    public ArrayList getTrue() {

        ArrayList values = new ArrayList();
        for (Map.Entry<String, Boolean> pair : must_haves.entrySet()) {
            if (pair.getValue() == true) {
                values.add(pair.getKey());
            }
        }
        return values;
    }
}


