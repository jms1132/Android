package com.example.hp.practice10_2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFinish;
    private ImageView[] iv = new ImageView[9];
    private Integer[] ivID = new Integer[]{R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
    private String ivName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
            "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
            "해변에서"};

    private int count[] = new int[9];
    final static int REQUEST_CODE = 1000;
    private int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFinish = findViewById(R.id.btnFinish);

        for (int i = 0; i < ivID.length; i++) {
            iv[i] = findViewById(ivID[i]);
            iv[i].setOnClickListener(this);
        }

        btnFinish.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv1:
                ivChecked(0);
                break;
            case R.id.iv2:
                ivChecked(1);
                break;
            case R.id.iv3:
                ivChecked(2);
                break;
            case R.id.iv4:
                ivChecked(3);
                break;
            case R.id.iv5:
                ivChecked(4);
                break;
            case R.id.iv6:
                ivChecked(5);
                break;
            case R.id.iv7:
                ivChecked(6);
                break;
            case R.id.iv8:
                ivChecked(7);
                break;
            case R.id.iv9:
                ivChecked(8);
                break;
            case R.id.btnFinish:
                if (checkCount() == 0) {
                    toastDisplay("Please Vote..");
                } else {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("ivName", ivName);
                    intent.putExtra("count", count);
                    startActivityForResult(intent, REQUEST_CODE);
                }
                break;

        }
    }

    private int checkCount() {
        for (int j = 0; j < iv.length; j++) {
            sum = sum + count[j];
        }
        return sum;
    }


    private void ivChecked(int i) {
        count[i] = (count[i] == 5) ? 5 : ++count[i];
        if (count[i] == 5) toastDisplay("No more Vote.");
        else toastDisplay(ivName[i] + " is voted " + count[i] + " times.");
    }

    private void toastDisplay(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent returnIntent) {
        super.onActivityResult(requestCode, resultCode, returnIntent);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String message = returnIntent.getStringExtra("message");
            toastDisplay(message + " Vote counting will be reset.");
            for (int i = 0; i < count.length; i++) {
                count[i] = 0;
            }
        }
    }
}
