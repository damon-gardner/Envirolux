package edu.donnelly.nicholas.envirolux;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class EpaUviData {
    int ORDER;
    String CITY;
    String STATE;
    String DATE_TIME;
    int UV_VALUE;

    String getMonth() {
        return DATE_TIME.substring(0, 3);
    }

    String getDay() {
        return getMonth() + DATE_TIME.substring(4,6);
    }

    String getTime() {
        return  DATE_TIME.substring(11, 14) + getPeriod();
    }

    String getPeriod() {
        return DATE_TIME.substring(15).toLowerCase();
    }

    String getUViIndex() {
        return "" + UV_VALUE;
    }

    static String getProtectionMessage(int index) {
        if (index > 10) {
            return "Message11";
        } else if (index > 7) {
            return "Message 7";

        } else if (index > 5) {
            return "Message 5";
        } else if (index > 2 ) {
            return "Message 2";
        } else if (index > 0) {
            return "Message 0";
        } else {
            return "Message Default";
        }
    }
}
