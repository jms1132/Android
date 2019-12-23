package com.example.hp.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



public class Fragment3Activity extends Fragment implements View.OnClickListener {

    Button f3BtnName;
    View view;

    public Fragment3Activity() {
    }

    //setContentView와 마찬가지로 inflate기능을 함
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3, container, false);
        f3BtnName = view.findViewById(R.id.f3BtnName);
        f3BtnName.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f3BtnName:
                toastDisplay("hey");
                break;
        }
    }

    private void toastDisplay(String message) {
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}