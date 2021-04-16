package edu.donnelly.nicholas.envirolux;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WaterViolationActivity extends AppCompatActivity {

    private EpaViolationData[] epaViolationData;

    private String city = "KANSAS CITY";
    private String state = "KS";
    private String baseUrl = "https://enviro.epa.gov/enviro/efservice/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_violation);

        fetchViolations();
    }

    private void fetchViolations() {

    }
}



//    private void fetchFacilityViolations(String pwsid) {
//
//        String url = baseUrl + "VIOLATION/PWSID/" + pwsid + "/JSON";
//        Log.d("EPA", url);
//
//        //RequestQueue queue = Volley.newRequestQueue(this);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        queueSize--;
//                        setEpaViolationData(response);
//                        Log.d("EPA", "fetchFacilityViolations");
//                        if (queue == null) {
//                            Log.d("EPA", "Done.");
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("EPA", "Error1");
//            }
//        });
//
//        queue.add(stringRequest);
//        queueSize++;
//       // Log.d("EPA", url);
//    }
//
//    private void setEpaViolationData(String response) {
//        Log.d("EPA", response);
//
//        Gson gson = new Gson();
//        Type userListType = new TypeToken<ArrayList<EpaViolationData>>(){}.getType();
//        ArrayList<EpaViolationData> temp = gson.fromJson(response, userListType);
//
//        for (EpaViolationData item: temp) {
//            Log.d("EPA", item.COMPL_PER_BEGIN_DATE);
//        }
//
//        try {
//
//            //ArrayList<EpaViolationData> tempList = (ArrayList<EpaViolationData>) Arrays.asList(epaViolationData);
//            epaViolationDataArrayList.addAll(temp);
//            if (queueSize == 0) {
//                TextView textView = (TextView) findViewById(R.id.tv_water_violation);
//                //textView.setText(epaViolationData.toString());
//                Toast.makeText(WaterViolationActivity.this, "Done", Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//            Log.d("EPA", e.toString());
//        } finally {
//            Log.d("EPA", "Total Size " + epaViolationDataArrayList.size());
////            if (queueSize == 0) {
////                TextView textView = (TextView) findViewById(R.id.tv_water_violation);
////                //textView.setText(epaViolationData.toString());
////                Toast.makeText(WaterViolationActivity.this, "Done", Toast.LENGTH_LONG).show();
////            }
//        }
//
//       // if (epaGeoAreaData)
//
////        if (temp.length > 0 ) {
////            List<EpaViolationData> tempList = Arrays.asList(epaViolationData);
////            epaViolationDataArrayList.addAll(tempList);
////        }
//
//      //  Log.d("EPA", ""+ epaViolationDataArrayList.size());
//
//    }
//
//
//    private void fetchWaterFacility() {
//       // RequestQueue queue = Volley.newRequestQueue(this);
//
//        String url = baseUrl + "GEOGRAPHIC_AREA/STATE_SERVED/" + state + "/CITY_SERVED/" + city + "/JSON";
//        Log.d("EPA", url);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        queueSize--;
//                        setEpaGeoAreaData(response);
//        //                Gson gson = new Gson();
//          //              epaGeoAreaData = gson.fromJson(response, EpaGeoAreaData[].class);
//                      //  new MyAsyncTask(response).execute();
//                        Log.d("EPA", response);
//                        Log.d("EPA", "GeoArea");
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("EPA", "Error1");
//            }
//        });
//        queue.add(stringRequest);
//        queueSize++;
//    }
//
//    void setEpaGeoAreaData(String response) {
//         Gson gson = new Gson();
//         epaGeoAreaData = gson.fromJson(response, EpaGeoAreaData[].class);
//           // UviAdapter adapter = new UviAdapter(data);
//
//        for (EpaGeoAreaData item : epaGeoAreaData) {
//
//            if (item.PWS_ACTIVITY_CODE == 'A') {
//                fetchFacilityViolations(item.PWSID);
//               // Log.d("EPA", item.PWSID);
//            }
//        }
//        Log.d("EPA", "Total Size = ");
//
//    }
//    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
//
//       // String response;
//        @Override
//        protected Void doInBackground(Void... voids) {
//           // setEpaGeoAreaData(response);
//            fetchWaterViolations();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//           display();
//        }
//
//
//    }
//
//    void display() {
//        Log.d("EPA", "Size before " + epaViolationDataArrayList.size());
//    }
//
//}