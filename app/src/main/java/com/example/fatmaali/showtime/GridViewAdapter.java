package com.example.fatmaali.showtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class GridViewAdapter extends BaseAdapter {
    private int lImage[];
    private Context mContext;
    private LayoutInflater inflater;

    public GridViewAdapter(int lImage[], Context mContext) {
        this.lImage = lImage;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return lImage.length;
    }

    @Override
    public Object getItem(int position) {
        return lImage;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridview = convertView;
        ImageView imageView;
        if (convertView == null) {
            inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridview = inflater.inflate(R.layout.custom_layout,null);
            imageView = gridview.findViewById(R.id.image);

            imageView.setImageResource(lImage[position]);
        }

        else {
//            imageView = (ImageView) convertView;

        }
        return gridview;
    }
}
