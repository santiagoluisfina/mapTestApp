package com.systango.maptestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btGoogleMaps = findViewById(R.id.bt_google_maps);
        Button btHuaweiMaps = findViewById(R.id.bt_huawei_maps);

        btGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGoogleMap = new Intent(getApplicationContext(), GoogleMapsActivity.class);
                startActivity(iGoogleMap);
            }
        });

        btHuaweiMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iHuaweiMap = new Intent(getApplicationContext(), HuaweiMapsActivity.class);
                startActivity(iHuaweiMap);
            }
        });
    }
}