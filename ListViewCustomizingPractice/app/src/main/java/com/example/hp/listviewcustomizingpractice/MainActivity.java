package com.example.hp.listviewcustomizingpractice;

import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<MyCustomDTO> list =
                new ArrayList<MyCustomDTO>();
        list.add(new MyCustomDTO(R.drawable.boksun, "캐나다", "캐나다 굿!", R.drawable.boksun));
        list.add(new MyCustomDTO(R.drawable.boksun2, "프랑스", "프랑스 굿!", R.drawable.boksun2));
        list.add(new MyCustomDTO(R.drawable.honey2, "대한민국", "대한민국 베리 굿!", R.drawable.honey2));
        list.add(new MyCustomDTO(R.drawable.boksun4, "멕시코", "멕시코 굿!", R.drawable.boksun4));
        list.add(new MyCustomDTO(R.drawable.boksun5, "폴란드", "폴란드 굿!", R.drawable.boksun5));

        listView = findViewById(R.id.listView1);

        MyCustomAdapter adapter = new MyCustomAdapter(getApplicationContext(), R.layout.list_row, list);

        listView.setAdapter(adapter);
    }
}
