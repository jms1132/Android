package com.example.hp.imagevoteratetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv[] = new TextView[9];
    Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};

    RatingBar rbar[] = new RatingBar[9];
    Integer rBarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

    Button btnReturn;

    int count[] = new int[9];
    String ivName[] = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        count = intent.getIntArrayExtra("count");
        ivName = intent.getStringArrayExtra("ivName");

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        for (int i = 0; i < tvID.length; i++) {
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rBarID[i]);
            rbar[i].setRating(count[i]);
        }//end of for문
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnReturn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("message", "Completely Finish :)...");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
