package com.example.umprojectadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Donation> donations;

    public MyAdapter(Context context, ArrayList<Donation> data) {
        mContext = context;
        donations = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return donations.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Donation getItem(int position) {
        return donations.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.donation_list_view_layout, null);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView umbrellaNum = (TextView)view.findViewById(R.id.umbrellaNum);

        image.setImageResource(R.drawable.umbrella);
        name.setText(donations.get(position).getName());
        umbrellaNum.setText(donations.get(position).getUnbrellaNum());

        return view;
    }
}
