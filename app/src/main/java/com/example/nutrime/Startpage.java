package com.example.nutrime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutrime.enums.MustHaves;

import java.util.ArrayList;

public class Startpage extends Fragment {

    public static Startpage newInstance() {
        return new Startpage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_startpage, container, false);

        Recipe recipe = ((MainActivity) requireActivity()).getRecipeOfTheDay();

        TextView name = view.findViewById(R.id.textView_name);
        TextView timing = view.findViewById(R.id.textView_rating);
        TextView properties1 = view.findViewById(R.id.textView_properties1);
        TextView properties2 = view.findViewById(R.id.textView_properties2);
        TextView properties3 = view.findViewById(R.id.textView_properties3);

        ImageView spoon1 = view.findViewById(R.id.img_spoon1);
        ImageView spoon2 = view.findViewById(R.id.img_spoon2);
        ImageView spoon3 = view.findViewById(R.id.img_spoon3);
        ImageView spoon4 = view.findViewById(R.id.img_spoon4);
        ImageView spoon5 = view.findViewById(R.id.img_spoon5);

        ImageView icon = view.findViewById(R.id.icon);

        name.setText(recipe.getName());
        timing.setText(String.valueOf(recipe.getPreparationTimePrettyPrint()));
        ArrayList<MustHaves> bestIngredients = recipe.getBestIngredients();
        properties1.setText(bestIngredients.get(0).toString());
        properties2.setText(bestIngredients.get(1).toString());
        properties3.setText(bestIngredients.get(2).toString());

        spoon1.setImageResource(R.mipmap.spoon_filled_foreground);
        spoon2.setImageResource(R.mipmap.spoon_empty_foreground);
        spoon3.setImageResource(R.mipmap.spoon_empty_foreground);
        spoon4.setImageResource(R.mipmap.spoon_empty_foreground);
        spoon5.setImageResource(R.mipmap.spoon_empty_foreground);
        if (recipe.getRating() > 1) {
            spoon2.setImageResource(R.mipmap.spoon_filled_foreground);
        }
        if (recipe.getRating() > 2) {
            spoon3.setImageResource(R.mipmap.spoon_filled_foreground);
        }
        if (recipe.getRating() > 3) {
            spoon4.setImageResource(R.mipmap.spoon_filled_foreground);
        }
        if (recipe.getRating() > 4) {
            spoon5.setImageResource(R.mipmap.spoon_filled_foreground);
        }

        icon.setImageResource(recipe.getPicture());

        return view;
    }
}