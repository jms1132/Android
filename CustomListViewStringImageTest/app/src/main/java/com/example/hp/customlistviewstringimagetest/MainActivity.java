package com.example.hp.customlistviewstringimagetest;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<MyCustomDAO> list=new ArrayList<MyCustomDAO>();
    private MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listInsertData();

        adapter = new MyCustomAdapter(getApplicationContext(), R.layout.list_item_data, list);
        listView.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "Close" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(200);
                // set item title
                openItem.setTitle("Close");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(200);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };


        listView.setMenuCreator(creator);

        listview.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
                listview.smoothOpenMenu(position);
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
                listview.smoothOpenMenu(position);
            }
        });
        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        Log.d("","--------close......");
                        break;
                    case 1:
                        // delete
                        Log.d("","--------delete......");  여기에 삭제 버턴 클릭시 코딩...
                        // delete<pre style="font-family: Menlo; font-size: 9pt;">                 long selectedid = adapter.getItemId(position);
                        int deleteid = (int) selectedid;
                        deleteRowDialog( deleteid );</pre>                break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        })

    }

    private void listInsertData() {
        for (int i = 0; i < 10; i++) {

            list.add(new MyCustomDAO("집에 보내줘 " + i));
        }
    }
}
