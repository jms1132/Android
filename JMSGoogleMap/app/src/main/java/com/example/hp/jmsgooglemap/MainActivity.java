package com.example.hp.jmsgooglemap;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    //조심할 것 import 제대로 되어 있는지 체크!
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.fgGoogleMap);
        mapFragment.getMapAsync(this);
    }

    // 구글맵이 준비되어 있으면 OnMapReady 라는 함수를 콜하고 구글맵을 받아갈 수 있게 해준다.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //시드니 월드스퀘어
        LatLng location = new LatLng(-33.876990, 151.206909);
        //좌표 위에 표시될 마킹할 부분을 선택해서 붙여놓는다.
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("시드니 월드스퀘어");
        //        //세부적인 내용
        markerOptions.snippet("시드니 콜스 장보던 곳");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
        //켜질때 카메라 살짝 멀리서 서서히 오듯 이동하는것이 보임
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

    }
}
