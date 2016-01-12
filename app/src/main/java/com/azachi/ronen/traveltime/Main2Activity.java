package com.azachi.ronen.traveltime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.CameraUpdate;

public class Main2Activity extends AppCompatActivity {

    GoogleMap map;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    private AutoCompleteTextView placeAutocomplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        placeAutocomplete=(AutoCompleteTextView)findViewById(R.id.autocomplete_places);

        String[] languages={"Android ","java","IOS","SQL","JDBC","Web services"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,languages);
        placeAutocomplete.setAdapter(adapter);

       // map  = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        SupportMapFragment mapFrag  = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        map = mapFrag.getMap();
        LatLng LOCATION_BURNABY = new LatLng(49.27645, -122.917587);
        map.addMarker(new MarkerOptions().position(LOCATION_BURNABY).title("Find me here!"));
//        mMap = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY, 14);
        map.animateCamera(update);

    }



}
