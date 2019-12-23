package com.example.swipelayouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

public class MainActivity extends AppCompatActivity {

    private SwipeLayout swipe_sample1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe_sample1=findViewById(R.id.swipe_sample1);
        swipe_sample1.setShowMode(SwipeLayout.ShowMode.LayDown);
//오른쪽에서 나오는 drag (tag로 설정한 HideTag가 보여짐
        swipe_sample1.addDrag(SwipeLayout.DragEdge.Right,swipe_sample1.findViewWithTag("HideTag"));
//swipe_layout을 클릭한 경우
        swipe_sample1.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
            }
        });
//star버튼을 클릭한 경우
        swipe_sample1.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Star", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
