package com.example.hp.mylistviewcreatertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<MyCustomDTO> list;
    LayoutInflater layoutInflater;

    public MyCustomAdapter(Context context, int layout, ArrayList<MyCustomDTO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, null);
        }
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtContent = convertView.findViewById(R.id.txtContent);
        ImageView imgIcon = convertView.findViewById(R.id.imgIcon);
        ImageView imgIcon1 = convertView.findViewById(R.id.imgIcon1);

        MyCustomDTO dto = list.get(position);
        txtTitle.setText(dto.getTitle());
        txtContent.setText(dto.getContent());
        imgIcon.setImageResource(dto.getImgIcon());
        imgIcon1.setImageResource(dto.getImgIcon1());

        return convertView;
    }

}
