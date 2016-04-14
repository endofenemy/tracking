package com.tracking.libraryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.tracking.tracking.services.FetchLocation;

public class MainActivity extends AppCompatActivity implements FetchLocation.GetLocation {
    Button start, stop;
    TextView positions;
    FetchLocation fetchLocation = new FetchLocation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        positions= (TextView) findViewById(R.id.position);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchLocation.setLocationListener(MainActivity.this);
                fetchLocation.initializeLocation(MainActivity.this);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchLocation.stopLocation(MainActivity.this);
            }
        });

    }

    @Override
    public void location(LatLng latLng) {
        positions.setText("Lat:" + latLng.latitude + "\nLon" + latLng.longitude);
    }
}
