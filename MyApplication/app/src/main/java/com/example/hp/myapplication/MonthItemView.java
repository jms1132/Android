package com.example.hp.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

// xml 로 생각하고 부분화면 으로 구분하면 된다.
public class MonthItemView extends AppCompatTextView {

    private MonthItemData item;

    public MonthItemView(Context context) {
        super(context);
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundColor(Color.WHITE);
    }

    public MonthItemData getItem() {
        return item;
    }

    public void setItem(MonthItemData item) {
        this.item = item;

        int day = item.getDayValue();
        if (day != 0) {
            setText(String.valueOf(day));
        } else {
            setText("");
        }
    }
}
