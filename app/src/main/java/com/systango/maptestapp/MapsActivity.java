package com.systango.maptestapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapFragment;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.Marker;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, com.huawei.hms.maps.OnMapReadyCallback {

    private static final boolean GOOGLE_MAPS_FLAG = false;
    private GoogleMap mMap;
    private HuaweiMap huaweiMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (GOOGLE_MAPS_FLAG) {
            // Google map
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            assert mapFragment != null;
            mapFragment.getMapAsync(this);
            Toast.makeText(this, "Google Maps", Toast.LENGTH_SHORT).show();
        } else {
            // Huawei map
            setContentView(R.layout.activity_maps_huawei);
            MapFragment mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment_mapfragmentdemo);
            mMapFragment.getMapAsync(this);
            Toast.makeText(this, "Huawei Maps", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 8));
    }

    @Override
    public void onMapReady(HuaweiMap map) {
    // after call getMapAsync method ,we can get HuaweiMap instance in this callback method
        huaweiMap = map;
        Marker mMarker = huaweiMap.addMarker(new com.huawei.hms.maps.model.MarkerOptions().position(new com.huawei.hms.maps.model.LatLng(31.2304, 121.4737)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_background)));
        //huaweiMap.moveCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(new com.huawei.hms.maps.model.LatLng(31.2304, 121.4737), 10));
        huaweiMap.animateCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(new com.huawei.hms.maps.model.LatLng(31.2304, 121.4737), 10));
    }
}