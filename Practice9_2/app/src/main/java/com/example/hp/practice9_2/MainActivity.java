package com.example.hp.practice9_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, SQUARE = 3, RED = 4, GREEN = 5, BLUE = 6;
    public int curShape = LINE; // 기본값을 라인으로 설정
    Paint paint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    //옵션 메뉴 등록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");

        SubMenu subMenu = menu.addSubMenu("색상 변경 >>");
        subMenu.add(0, 4, 0, "빨강");
        subMenu.add(0, 5, 0, "초록");
        subMenu.add(0, 6, 0, "파랑");

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE;
                break;
            case 2:
                curShape = CIRCLE;
                break;
            case 3:
                curShape = SQUARE;
                break;
            case 4:
                paint.setColor(Color.RED);
                break;
            case 5:
                paint.setColor(Color.GREEN);
                break;
            case 6:
                paint.setColor(Color.BLUE);
                break;

        }
        return true;
    }

    private class MyGraphicView extends View {
        public float startX = -1, startY = -1, endX = -1, endY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }

        public MyGraphicView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = event.getX();
                    startY = event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    endX = event.getX();
                    endY = event.getY();
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // paint 속성만 정의

            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);


            //라인인지 원인지 선택
            switch (curShape) {
                case LINE:

                    canvas.drawLine(startX, startY, endX, endY, paint);
                    break;
                case CIRCLE:

                    int radius = (int) Math.sqrt(Math.pow(endX - startX, 2)
                            + Math.pow(endY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case SQUARE:

                    canvas.drawRect(startX, startY, endX, endY, paint);


            }

        }
    }
}
