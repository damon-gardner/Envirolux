package edu.donnelly.nicholas.envirolux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class WaterSuppliersActivity extends AppCompatActivity {
    private String state = "KS";
    private String city = "KANSAS CITY";
    private String baseUrl = "https://enviro.epa.gov/enviro/efservice/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_suppliers);

        fetchEpaGeoAreaData();
    }

    void fetchEpaGeoAreaData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = baseUrl + "GEOGRAPHIC_AREA/STATE_SERVED/" + state.toUpperCase() +
                               "/CITY_SERVED/" + city.toUpperCase() + "/JSON";
        Log.d("EPA", url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("EPA", response);
                        displayEpaGeoAreaData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("EPA", "Error1");
            }
        });
        queue.add(stringRequest);
    }

    private void displayEpaGeoAreaData(String response) {
        Log.d("EPA", "Test");
        Gson gson = new Gson();
        EpaGeoAreaData[] data = gson.fromJson(response, EpaGeoAreaData[].class);
        GeoAreaAdapter adapter = new GeoAreaAdapter(data);

        Log.d("EPA", ""+data.length);

        //TextView locationTextView = (TextView) findViewById(R.id.tv_uvi_location);
        //locationTextView.setText(city + state);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_water_supplier);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(WaterSuppliersActivity.this));
    }
}