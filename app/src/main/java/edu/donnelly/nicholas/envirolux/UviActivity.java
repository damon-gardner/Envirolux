package edu.donnelly.nicholas.envirolux;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class UviActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;

    private ArrayList<EpaUviData> epaUviData;
    private String city = "Kansas City";
    private String state = "KS";
    private String baseUrl = "https://enviro.epa.gov/enviro/efservice/getEnvirofactsUVHOURLY/CITY/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uvi);

        fetchEpaData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            this.state = data.getStringExtra("state");
            this.city = data.getStringExtra("city");

            fetchEpaData();
        }
    }

    void fetchEpaData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = baseUrl + city + "/STATE/" + state + "/JSON";
        Log.d("EPA", url);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        displayEpaData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("EPA", "Error1");
            }
        });
        queue.add(stringRequest);
    }

     void displayEpaData(String response) {
       // Log.d("EPA", response);
        //TextView tv = findViewById(R.id.textView);
        //tv.setText(response);
         Gson gson = new Gson();
         EpaUviData[] data = gson.fromJson(response, EpaUviData[].class);
         UviAdapter adapter = new UviAdapter(data);

         TextView locationTextView = (TextView) findViewById(R.id.tv_uvi_location);
         locationTextView.setText(city + state);

         RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_uvi_hour);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(UviActivity.this));
    }

    public void startLocationActivity(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivityForResult(intent, 200);
    }
}