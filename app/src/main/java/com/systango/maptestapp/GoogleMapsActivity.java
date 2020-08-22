package com.systango.maptestapp;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Google map
        setContentView(R.layout.activity_maps_google);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapGoogle);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        Toast.makeText(this, "Google Maps", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Roma and move the camera
        LatLng romaLatLng = new LatLng(41.902782, 12.496366);
        googleMap.addMarker(new MarkerOptions().position(romaLatLng).title("Marcatore in Roma"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(romaLatLng, 8));
    }
}