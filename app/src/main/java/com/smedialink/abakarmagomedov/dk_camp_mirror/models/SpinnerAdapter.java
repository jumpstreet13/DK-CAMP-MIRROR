package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater mInflater;

    public SpinnerAdapter(List<String> list, Context context) {
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = mInflater.inflate(R.layout.spinner_element,parent, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView_spinner);
        textView.setText(list.get(position));
        return view;
    }
}
