package com.example.hp.imagecapturetest;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_IMAGE_CAPTURE = 672;
    private ImageView imageView;
    private Button btnShoot;
    private String imageFilePath;
    private Uri photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShoot = findViewById(R.id.btnShoot);
        imageView = findViewById(R.id.imageView);

        TedPermission.with(getApplicationContext()).setPermissionListener(new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                toastDisplay("권한 허용됨");
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                toastDisplay("카메라를 사용할 수 없습니다");
            }
        }).setRationaleMessage("카메라 권한 필요합니다")
                .setDeniedMessage("겁부하시면 안되는데")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .check();

        btnShoot.setOnClickListener(this);
    }

    private void toastDisplay(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnShoot){
            // 카메라앱을 띄워달라는 요청
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            //패키지 매니저한테 인텐트 처리할 앱이 있는지 물어봄 - 널이 아니면 된다는 소리
            if(intent.resolveActivity(getPackageManager()) != null){
                //파일명 만들기 (날짜,시간,분,초 + 랜덤 + .jpg)
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (photoFile != null) {
                    photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile);
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);

            ExifInterface exifInterface = null;
            // 속성을 체크해야함
            try {
                exifInterface = new ExifInterface(imageFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int exifOrientation; // 방향설정 값을 저장하는 변수
            int exifDegree; // Degree 설정 값을 저장하는 변수

            if (exifInterface != null) {
                exifOrientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                exifDegree = exifOrientationToDegress(exifOrientation);
            } else {
                exifDegree = 0;
            }
            Bitmap bitmapTemp = rotate(bitmap,exifDegree);
            imageView.setImageBitmap(bitmapTemp);
        }
    }

    private Bitmap rotate(Bitmap bitmap, int exifDegree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(exifDegree);
        Bitmap tempBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return tempBitmap;
    }

    private int exifOrientationToDegress(int exifOrientation) {
        switch (exifOrientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return 90;
            case ExifInterface.ORIENTATION_ROTATE_180:
                return 180;
            case ExifInterface.ORIENTATION_ROTATE_270:
                return 270;
        }
        return 0;
    }

    private File createImageFile() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timeStamp = simpleDateFormat.format(new Date());
        String imageFileName = "test_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES); //외부장치 디렉토리명을 파일로 가져옴

        File image = File.createTempFile(imageFileName, ".jpg", storageDir); // 여기서 랜덤값.jpg가 붙음
        imageFilePath = image.getAbsolutePath();
        Log.d("createImageFile", imageFileName);
        Log.d("createImageFile", imageFilePath);

        return image;
    }
}