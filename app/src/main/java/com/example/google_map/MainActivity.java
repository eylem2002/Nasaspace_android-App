package com.example.google_map;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView msgTV;
    Button b;
    public static List<fireData> fireDataList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button) findViewById(R.id.next);

        msgTV = findViewById(R.id.idTVMsg);

//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
//                startActivity(intent);
//            }
//        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://firms.modaps.eosdis.nasa.gov/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitAPICall retrofitAPI = retrofit.create(RetrofitAPICall.class);


        String mapKey = "1c042fc10e6dd87b8a53350a7c8385fd";
        String source = "VIIRS_SNPP_NRT";
        String areaCoordinates = "world/1";
        String dayRange = "2023-10-01";


        Call<String> call = retrofitAPI.getData(mapKey, source, areaCoordinates, dayRange);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                //msgTV.setText(response.body());
                 //   fireDataList  = parseCSVData();
                  //  String msg=response.body().toString();

                  //  Log.d(TAG,msg);



                } else {
                    Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra("fireDataList", (Serializable) fireDataList);
        startActivity(intent);

    }
    /*
    private List<fireData> parseCSVData() {

        List<fireData> fireDataList = new ArrayList<>();
        try {
            final InputStream inputStream = getResources().openRawResource(response.body());
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            int dd=1;
            bufferedReader.readLine();// to skip first line .
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
    }*/


}
