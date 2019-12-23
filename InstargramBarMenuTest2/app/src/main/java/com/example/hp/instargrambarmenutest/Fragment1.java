package com.example.hp.instargrambarmenutest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.ArrayList;

public class Fragment1 extends Fragment {

    private View view;
    private ArrayList<com.example.hp.instargrambarmenutest.MainData> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button btnAdd;
    private LinearLayoutManager linearLayoutManager;
    private com.example.hp.instargrambarmenutest.MainAdapter mainAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        btnAdd = view.findViewById(R.id.btnAdd);

        linearLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        list =  new ArrayList<>();
        mainAdapter = new com.example.hp.instargrambarmenutest.MainAdapter(R.layout.recyclerview_item, list);
        recyclerView.setAdapter(mainAdapter);
        // 여기까지는 listView 와 같다.

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.hp.instargrambarmenutest.MainData mainData = new com.example.hp.instargrambarmenutest.MainData(R.mipmap.ic_launcher, "정민지", "졸리다");
                list.add(mainData);
                mainAdapter.notifyDataSetChanged();
            }
        });



        return view;
    }
}
