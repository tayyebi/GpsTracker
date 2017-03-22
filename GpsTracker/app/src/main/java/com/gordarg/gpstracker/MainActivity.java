package com.gordarg.gpstracker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn_Send)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if (gps.canGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLatitude();

                    /*
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("Latitude", new StringBuilder().append(latitude).toString()));
                    nameValuePairs.add(new BasicNameValuePair("Longitude", new StringBuilder().append(longitude).toString()));

                    POST post = new POST("this is a test");
                    String Res = post.execute(nameValuePairs).toString();
                    */

                    Toast.makeText(getApplicationContext(), "Longitude: " + String.valueOf(longitude) + "\n" + "Latitude: " + String.valueOf(latitude), Toast.LENGTH_LONG).show();


                    GET get = new GET();
                    String Res = get.execute("http://192.168.93.1/WA/api/Values?Longitude=" + String.valueOf(longitude) + "&Latitude=" + String.valueOf(latitude)).toString();


                    Toast.makeText(getApplicationContext(), Res, Toast.LENGTH_LONG).show();

                    // ((TextView) findViewById(R.id.gps_location)).setText("Your Location is - \nLat: " + latitude + "\nLong: " + longitude);
                } else {

                    gps.showSettingsAlert();
                }

            }
        });

    }
}