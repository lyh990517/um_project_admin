package com.example.umprojectadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InquiryAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Inquiry> inquiries;

    public InquiryAdapter(Context context, ArrayList<Inquiry> data) {
        mContext = context;
        inquiries = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return inquiries.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Inquiry getItem(int position) {
        return inquiries.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.inquiry_list_view_layout, null);
        TextView name = (TextView)view.findViewById(R.id.title);
        TextView umbrellaNum = (TextView)view.findViewById(R.id.writer);

        name.setText(inquiries.get(position).getTitle());
        umbrellaNum.setText(inquiries.get(position).getWriter());

        return view;
    }
}
