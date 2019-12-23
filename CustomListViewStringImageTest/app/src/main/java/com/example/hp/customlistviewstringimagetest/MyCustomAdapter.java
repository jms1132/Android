package com.example.hp.customlistviewstringimagetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    //this 를 저장할 멤버변수가 필요하다.
    private Context context;
    private int layout;
    private ArrayList<MyCustomDAO> list;

    //일반 클래스에서 스스로가 인플레이션을 진행하려면 Context 에게 요청을 해서 받아와야 한다.
    private LayoutInflater layoutInflater;

    public MyCustomAdapter(Context context, int layout, ArrayList<MyCustomDAO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;

        //인플레이트 할수 있도록 기능을 요청해서 받아온다.
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //데이터 자료 개수를 리턴해준다.
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

    //
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = layoutInflater.inflate(layout, null);
        }

        final TextView textView = view.findViewById(R.id.textView);

        MyCustomDAO myCustomDAO = list.get(position);
        textView.setText(myCustomDAO.getStringData());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
