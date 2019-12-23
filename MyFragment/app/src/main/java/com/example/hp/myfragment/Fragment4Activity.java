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

public class Fragment4Activity extends Fragment implements View.OnClickListener {
    public Fragment4Activity() {
    }

    Button f4bBtnName;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment4, container, false);
        f4bBtnName = view.findViewById(R.id.f4BtnName);
        f4bBtnName.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f4BtnName:
                toastDisplay("I will come back tomorrow..Just let me go...:(");
                break;
        }
    }

    private void toastDisplay(String s) {
        Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
    }

}

