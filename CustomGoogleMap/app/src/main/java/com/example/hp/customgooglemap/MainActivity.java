package com.example.hp.customgooglemap;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    GroundOverlayOptions cctvMark;
    ArrayList<GroundOverlayOptions> cctvList = new ArrayList<GroundOverlayOptions>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gMap)).getMapAsync(this);


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        gMap = googleMap;
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                //시드니 월드스퀘어
                LatLng location = new LatLng(-33.876825, 151.206921);
                //좌표 위에 표시될 마킹할 부분을 선택해서 붙여놓는다.
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title("시드니 월드스퀘어");
                //세부적인 내용
                markerOptions.snippet("시드니 콜스 장보던 곳");
                markerOptions.position(location);
                googleMap.addMarker(markerOptions);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
                //켜질때 카메라 살짝 멀리서 서서히 오듯 이동하는것이 보임
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));



                cctvMark = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.star_icon)).position(latLng, 100f, 100f);
                cctvList.add(cctvMark);
                for(int i = 0 ; i < cctvList.size() ; i++){
                    gMap.addGroundOverlay(cctvList.get(i));


                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        menu.add(0, 3, 0, "바로전 CCTV 지우기");
        menu.add(0, 4, 0, "모든 CCTV 지우기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                gMap.clear();
                cctvList.remove(cctvList.size() - 1);
                for(int i=0; i<cctvList.size();i++)
                    gMap.addGroundOverlay(cctvList.get(i));
                return true;
            case 4:
                gMap.clear();
                cctvList.removeAll(cctvList);
                return true;
        }
        return false;
    }

}

