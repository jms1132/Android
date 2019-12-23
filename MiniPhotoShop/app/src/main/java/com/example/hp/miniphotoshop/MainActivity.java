package com.example.hp.miniphotoshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton ibZoomIn, ibZoomOut, ibRotate, ibBright, ibDark, ibGray;
    LinearLayout pictureLayout;
    MyGraphicView graphicView;

    float scaleX = 1.0f, scaleY = 1.0f;
    float color = 1.0f;
    float satur = 1.0f;
    float angle = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        ibZoomIn = findViewById(R.id.ibZoomIn);
        ibZoomOut = findViewById(R.id.ibZoomOut);
        ibRotate = findViewById(R.id.ibRotate);
        ibBright = findViewById(R.id.ibBright);
        ibDark = findViewById(R.id.ibDark);
        ibGray = findViewById(R.id.ibGray);
        pictureLayout = findViewById(R.id.pictureLayout);

        graphicView = new MyGraphicView(this);
        //메인엑티비티 리니어레이아웃 비트맵 뷰로 작동한다.
        pictureLayout.addView(graphicView);

        //이벤트 설정
        ibZoomIn.setOnClickListener(this);
        ibZoomOut.setOnClickListener(this);
        ibRotate.setOnClickListener(this);
        ibBright.setOnClickListener(this);
        ibDark.setOnClickListener(this);
        ibGray.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibZoomIn:
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
                break;

            case R.id.ibZoomOut:
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
                break;

            case R.id.ibRotate:
                angle = angle + 20.0f;
                graphicView.invalidate();
                break;

            case R.id.ibBright:
                color = color + 0.2f;
                graphicView.invalidate();
                break;

            case R.id.ibDark:
                color = color - 0.2f;
                graphicView.invalidate();
                break;

            case R.id.ibGray:
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;
                graphicView.invalidate();
                break;
        }
    }


    private class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
    }

        public MyGraphicView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //MyGraphicView 중심점
            int centX = this.getWidth() / 2;
            int centY = this.getHeight() / 2;
            //스케일을 정한다.(zoomin, zoomout 멤버변수 참조)
            canvas.scale(scaleX, scaleY, centX, centY);
            canvas.rotate(angle, centX, centY);
            //붓을 결정한다.
            Paint paint = new Paint();

            //Bright, Dark 값을 적용하기 위한 내용
            float[] array = {color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0, 1, 0};

            ColorMatrix colorMatrix = new ColorMatrix(array);

            //회색영상 값 설정코드
            if (satur == 0.0) {
                colorMatrix.setSaturation(0.0f);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

            //이미지를 비트맵으로 가져온다.
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.mipmap.honey2);
            //비트맵을 캔버스 중앙에 그리기 위해 좌표를 계산한다.
            int x = (this.getWidth() - picture.getWidth()) / 2;
            int y = (this.getHeight() - picture.getHeight()) / 2;

            //캔버스에 비트맵을 그린다.
            canvas.drawBitmap(picture, x, y, paint);

            //비트맵을 메모리에 로딩한다. (=메모리 버퍼 기능을 한다)
            picture.recycle();
            //무효화 영역처리 요청을 하는 것이기 때문에 자동으로 onDraw()를 콜한다.
            invalidate();
        }
    }//end of MyGraphicView
}
