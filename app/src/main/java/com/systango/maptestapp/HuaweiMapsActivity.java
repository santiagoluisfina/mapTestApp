package com.systango.maptestapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapFragment;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

public class HuaweiMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    private static final String[] RUNTIME_PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET};

    private static final int REQUEST_CODE = 100;

    private HuaweiMap hmap;

    private Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!hasPermissions(this, RUNTIME_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, RUNTIME_PERMISSIONS, REQUEST_CODE);
        }

        // Huawei map
        setContentView(R.layout.activity_maps_huawei);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapHuawei);
        assert mMapFragment != null;

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        MapsInitializer.setApiKey("CgB6e3x9qfwag6SSQhliCkHP5XMcU+NMbl6RGKSBFPZHXa4AtNxpzZgJ1RiO69Y6cr73kccYRJG8JtjwWc95PzGA");
        mMapFragment.onCreate(mapViewBundle);

        mMapFragment.getMapAsync(this);
        Toast.makeText(this, "Huawei Maps", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        // after call getMapAsync method, we can get HuaweiMap instance in this callback method
        LatLng romaLatLng = new LatLng(41.902782, 12.496366);

        hmap = huaweiMap;

        mMarker = hmap.addMarker(new MarkerOptions().position(romaLatLng).title("Marcatore in Roma")
                .clusterable(true));

        mMarker.showInfoWindow();

        hmap.animateCamera(CameraUpdateFactory.newLatLngZoom(romaLatLng, 8));
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}