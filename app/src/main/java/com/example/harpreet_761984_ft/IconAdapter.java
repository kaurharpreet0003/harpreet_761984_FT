package com.example.harpreet_761984_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

class IconAdapter extends BaseAdapter {
    int[] image;
    Context context;

    public IconAdapter(Context context, int[] image){

        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);


        ImageView imageView = convertView.findViewById(R.id.images);

        imageView.setImageResource(image[position]);
        return  convertView;


    }
}
