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

public class Fragment2Activity extends Fragment implements View.OnClickListener {
    public Fragment2Activity() {
    }

    Button f2bBtnName;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        f2bBtnName = view.findViewById(R.id.f2BtnName);
        f2bBtnName.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f2BtnName:
                toastDisplay("Did you eat lunch? :(");
                break;
        }
    }

    private void toastDisplay(String s) {
        Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
    }

}
