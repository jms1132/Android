package com.example.hp.imagevoteratetest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView[] iv = new ImageView[9];
    private Integer[] ivID = new Integer[]{R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
    private Button btnResult;
    private String[] ivName = {"Picture 1", "Picture 2", "Picture 3", "Picture 4", "Picture 5", "Picture 6", "Picture 7", "Picture 8", "Picture 9"};
    private int count[] = new int[9];
    final static int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnResult = findViewById(R.id.btnResult);
        for (int i = 0; i < ivID.length; i++) {
            iv[i] = findViewById(ivID[i]);
            iv[i].setOnClickListener(this);
        }

        btnResult.setOnClickListener(this);

    }

    @Override//모든 이벤트를 처리하는 콜백 함수
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
            case R.id.btnResult:
                if()
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("ivName", ivName);
                intent.putExtra("count", count);
                startActivityForResult(intent, REQUEST_CODE);
//                startActivity(intent);
                break;
        }//end of switch
    }//end of onClick

    private void ivChecked(int i) {
        count[i] = (count[i] == 5) ? 5 : ++count[i];
        if (count[i] == 5) toastDisplay("No more vote.");
        else toastDisplay(ivName[i] + " is voted " + count[i] + " times.");
    }

    private void toastDisplay(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent returnIntent) {
        super.onActivityResult(requestCode, resultCode, returnIntent);
        if(requestCode==REQUEST_CODE && resultCode == RESULT_OK){
            String message = returnIntent.getStringExtra("message");
            toastDisplay(message+" Vote counting will be reset.");
            for(int i=0;i<count.length;i++){
                count[i]=0;
            }
        }
    }
}
