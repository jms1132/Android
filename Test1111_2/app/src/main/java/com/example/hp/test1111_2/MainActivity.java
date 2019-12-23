package com.example.hp.test1111_2;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static int count = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    count += 1;
                    count = (count > 4) ? (1) : (count);

            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.animal5);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();
            BlurMaskFilter bMask;

            switch (count) {
                case 1:
                    bMask = new BlurMaskFilter(1000, BlurMaskFilter.Blur.NORMAL);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    invalidate();
                    picture.recycle();
                    break;
                case 2:
                    bMask = new BlurMaskFilter(1000, BlurMaskFilter.Blur.INNER);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    invalidate();
                    picture.recycle();
                    break;
                case 3:

                    bMask = new BlurMaskFilter(1000, BlurMaskFilter.Blur.OUTER);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    invalidate();
                    picture.recycle();
                    break;
                case 4:
                    bMask = new BlurMaskFilter(1000, BlurMaskFilter.Blur.SOLID);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    invalidate();
                    picture.recycle();
                    break;
            }


        }
    }
}
