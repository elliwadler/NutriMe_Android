package com.example.nutrime;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String name_List[];
    String rating_List[];
    int flags[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] name_List, String[] rating_List, int[] flags) {
        this.context = context;
        this.name_List = name_List;
        this.rating_List = rating_List;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return name_List.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView name = (TextView) view.findViewById(R.id.textView_name);
        TextView rating = (TextView) view.findViewById(R.id.textView_rating);

        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        name.setText(name_List[i]);
        rating.setText(rating_List[i]);
        icon.setImageResource(flags[i]);
        return view;
    }
}