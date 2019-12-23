package com.example.hp.fragmentviewtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1Activity extends Fragment implements View.OnClickListener {
    public Fragment1Activity() {
    }

    Button f1bBtnName;
    View view;
    private static final String TAG = "FragmentActivity";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        f1bBtnName = view.findViewById(R.id.f1BtnName);
        f1bBtnName.setOnClickListener(this);

        String userId = getArguments().getString("userId");
        Log.d(TAG, "userId" + userId);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (view.getId()) {
            case R.id.f1BtnName:
                toastDisplay("Nice to meet u :)");
                break;
        }
    }

    private void toastDisplay(String s) {
        Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
    }

}
