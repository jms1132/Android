package com.example.hp.practice6_3;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    TabHost tabHost;
    TabHost.TabSpec animal1, animal2, animal3, animal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = getTabHost();

        animal1 = tabHost.newTabSpec("animal1").setIndicator("호주 앵무새");
        animal1.setContent(R.id.animal1);
        tabHost.addTab(animal1);

        animal2 = tabHost.newTabSpec("animal2").setIndicator("호주 코알라");
        animal2.setContent(R.id.animal2);
        tabHost.addTab(animal2);

        animal3 = tabHost.newTabSpec("animal3").setIndicator("호주 왈라비");
        animal3.setContent(R.id.animal3);
        tabHost.addTab(animal3);

        animal4 = tabHost.newTabSpec("animal4").setIndicator("호주 큰새");
        animal4.setContent(R.id.animal4);
        tabHost.addTab(animal4);

        tabHost.setCurrentTab(0);
    }
}
