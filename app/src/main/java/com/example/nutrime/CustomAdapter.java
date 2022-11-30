package com.example.nutrime;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String name_List[];
    String rating_List[];
    String time_List[];
    int pictures[];
    ArrayList properties_List;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] name_List, String[] rating_List, int[] pictures, ArrayList properties_List, String[] time_List) {
        this.context = context;
        this.name_List = name_List;
        this.rating_List = rating_List;
        this.pictures = pictures;
        this.properties_List = properties_List;
        this.time_List = time_List;
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
        TextView time = (TextView) view.findViewById(R.id.textView_timing);

        TextView properties1 = (TextView) view.findViewById(R.id.textView_properties1);
        TextView properties2 = (TextView) view.findViewById(R.id.textView_properties2);
        TextView properties3 = (TextView) view.findViewById(R.id.textView_properties3);

        ImageView spoon1 =  view.findViewById(R.id.img_spoon1);
        ImageView spoon2 =  view.findViewById(R.id.img_spoon2);
        ImageView spoon3 =  view.findViewById(R.id.img_spoon3);
        ImageView spoon4 =  view.findViewById(R.id.img_spoon4);
        ImageView spoon5 =  view.findViewById(R.id.img_spoon5);

        spoon1.setImageResource( R.mipmap.spoon_filled_foreground);
        spoon2.setImageResource( R.mipmap.spoon_filled_foreground);
        spoon3.setImageResource( R.mipmap.spoon_empty_foreground);
        spoon4.setImageResource( R.mipmap.spoon_empty_foreground);
        spoon5.setImageResource( R.mipmap.spoon_empty_foreground);

        String[] value = (String[]) properties_List.get(i);

        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        name.setText(name_List[i]);
        rating.setText(rating_List[i]+" Kochlöffel");
        time.setText(time_List[i]);

        if(value.length>=1){
            properties1.setText(value[0]);
            if (value.length >= 2){
                properties2.setText(value[1]);
                if(value.length >= 3) {
                    properties3.setText(value[2]);
                }
            }
        }
        icon.setImageResource(pictures[i]);
        return view;

    }

}