package edu.donnelly.nicholas.envirolux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);
    }

    public void startUviActivity(View view) {
        Intent intent = new Intent(this, UviActivity.class);
        startActivity(intent);
    }

    public void startWaterViolationActivity(View view) {
        Intent intent = new Intent(this, WaterViolationActivity.class);
        startActivity(intent);
    }

    public void startWaterSuppliersActivity(View view) {
        Log.d("EPA", "Water Suppliers");
        Intent intent = new Intent(this, WaterSuppliersActivity.class);
        startActivity(intent);
    }
}