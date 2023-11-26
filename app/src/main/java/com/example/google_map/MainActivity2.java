package com.example.google_map;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;
    static double longii=35.9902762;

    static double latii=32.4951568;
    public static List<fireData> fireDataList ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fireDataList  = parseCSVData();


//           // TextView latitudeTextView = findViewById(R.id.latitudeTextView);
//            //TextView longitudeTextView = findViewById(R.id.longitudeTextView);
//
//            //latitudeTextView.setText("Latitude: here" + firstFireData.getLatitude());
//            //longitudeTextView.setText("Longitude: " + firstFireData.getLongitude());
//        }
//        else {
//            Log.e("CSV Parse Error", "Invalid number of columns: " );
//        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync( this);


    }


//          .snippet(fireDataList.get(0).getDaynight())
//                   .icon(BitmapDescriptorFactory.fromResource(R.drawable.rec)));

    @Override
    public void onMapReady (@NonNull GoogleMap googleMap){

        myMap = googleMap;
        int counter=0;



        for(int i=0;i<fireDataList.size();i++) {
            Marker markerBrisbane;
            LatLng location = new LatLng(fireDataList.get(i).getLatitude(), fireDataList.get(i).getLongitude());
            markerBrisbane = myMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title(fireDataList.get(i).getAcq_date()));
            markerBrisbane.setTag(i);


            // Toast.makeText(this, "the location  "+fireDataList.get(i).getLatitude()+" "+fireDataList.get(i).getLongitude(), Toast.LENGTH_LONG).show();

            counter++;
        }





        LatLng firstLocation = new LatLng(fireDataList.get(0).getLatitude(), fireDataList.get(0).getLongitude());
        CameraPosition cam = new CameraPosition.Builder()
                .target(firstLocation)
                .zoom(15)
                .tilt(0)
                .bearing(30)
                .build();

        myMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));

        myMap.getUiSettings().setZoomControlsEnabled(true);

        //  myMap.addMarker(new MarkerOptions().position(Amman).title("Malak"));

        //      myMap.moveCamera(CameraUpdateFactory.newLatLng(Amman));

//        myMap.addMarker(new MarkerOptions().position(JordanUniversity).title("JordanUniversity"));
//        // myMap.moveCamera(CameraUpdateFactory.newLatLng(JordanUniversity));
        //here
//   CameraPosition cam=new CameraPosition.Builder().target(Amman).zoom(15).tilt(0).bearing(30).build();
//        myMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
//        myMap.getUiSettings().setZoomControlsEnabled(true);





    }

    private List<fireData> parseCSVData() {

        List<fireData> fireDataList = new ArrayList<>();
        try {
            final InputStream inputStream = getResources().openRawResource(R.raw.nasa_data);
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            int dd=1;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 14) {
                    fireData fireData = new fireData();
                    fireData.setLatitude(Double.parseDouble(values[0]));
                    fireData.setLongitude(Double.parseDouble(values[1]));
                    fireData.setBright_ti4(Double.parseDouble(values[2]));
                    fireData.setScan(Double.parseDouble(values[3]));
                    fireData.setTrack(Double.parseDouble(values[4]));
                    fireData.setAcq_date(values[5]);
                    fireData.setAcq_time(Integer.parseInt(values[6]));
                    fireData.setSatellite(values[7]);
                    fireData.setInstrument(values[8]);
                    fireData.setConfidence(values[9]);
                    fireData.setVersion(values[10]);
                    fireData.setBright_ti5(Double.parseDouble(values[11]));
                    fireData.setFrp(Double.parseDouble(values[12]));
                    fireData.setDaynight(values[13]);
                    fireDataList.add(fireData);
                    dd++;

                    //  Toast.makeText(getApplicationContext(), "numbrt "+values[0]+" "+values[1], Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "2 CSV Parse Error Invalid number of columns: ", Toast.LENGTH_SHORT).show();

                }
            }
            bufferedReader.close();
        }

        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), " the problem here ", Toast.LENGTH_SHORT).show();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fireDataList;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();



        if (id==R.id.normal){
            myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        if (id==R.id.hybrid) {
            myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        } else if (id==R.id.none) {
            myMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        }
        else if (id==R.id.terrain) {
            myMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
        else if (id==R.id.satellite) {
            myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }

        // true then changes effect of items
        return true;
    }
}



