package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
/*
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
*/
/*
public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public String name,longitude,latitude;
    public double log ,lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        name= (String) extras.get("name");
        longitude= (String) extras.get("longitude");
        latitude = (String) extras.get("latitude");
        log= Double.parseDouble(longitude);
        lat= Double.parseDouble(latitude);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, log);
        mMap.addMarker(new MarkerOptions().position(sydney).title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.petbusqueda)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

    }
}
*/