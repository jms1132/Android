package com.example.hp.practice7_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    RelativeLayout relativeLayout;
    EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = findViewById(R.id.imgView);
        relativeLayout = findViewById(R.id.relativeLayout);
        editTxt = findViewById(R.id.editTxt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                imgView.setImageResource(R.drawable.animal1);
                break;
            case R.id.item2:
                imgView.setImageResource(R.drawable.animal2);
                break;
            case R.id.item3:
                imgView.setImageResource(R.drawable.animal3);
                break;
            case R.id.imgRotation:
                imgView.setRotation(Float.parseFloat(editTxt.getText().toString()));
        }
        return false;
    }
}