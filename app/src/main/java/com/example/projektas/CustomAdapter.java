package com.example.projektas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<ReminderModel> data;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Activity a, ArrayList<ReminderModel> model){
        activity = a;
        data = model;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null)
            view = inflater.inflate(R.layout.adapter_view,null);

        TextView textView = (TextView) view.findViewById(R.id.textView4);
        TextView dateView = (TextView) view.findViewById(R.id.textView3);

        final ReminderModel model = data.get(position);
        textView.setText(model.getText());
        dateView.setText(model.getDate());

        return view;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
