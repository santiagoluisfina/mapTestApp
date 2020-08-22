package com.systango.maptestapp;

import android.os.Bundle;
import android.widget.Toast;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapFragment;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

public class HuaweiMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Huawei map
        setContentView(R.layout.activity_maps_huawei);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapHuawei);
        assert mMapFragment != null;
        MapsInitializer.setApiKey("CgB6e3x9qfwag6SSQhliCkHP5XMcU+NMbl6RGKSBFPZHXa4AtNxpzZgJ1RiO69Y6cr73kccYRJG8JtjwWc95PzGA");

        mMapFragment.getMapAsync(this);
        Toast.makeText(this, "Huawei Maps", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        // after call getMapAsync method, we can get HuaweiMap instance in this callback method
        LatLng romaLatLng = new LatLng(41.902782, 12.496366);
        huaweiMap.addMarker(new MarkerOptions().position(romaLatLng).title("Marcatore in Roma"));
        huaweiMap.animateCamera(CameraUpdateFactory.newLatLngZoom(romaLatLng, 8));
    }
}