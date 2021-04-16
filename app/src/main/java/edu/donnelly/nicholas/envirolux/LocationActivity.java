package edu.donnelly.nicholas.envirolux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void closeLocationActivity(View view) {
        Intent intent = new Intent();
        TextView stateTextView = (TextView) findViewById(R.id.pt_layout_state);
        TextView cityTextView = (TextView) findViewById(R.id.pt_layout_city);
        intent.putExtra("state", stateTextView.getText().toString());
        intent.putExtra("city", cityTextView.getText().toString());
        setResult(200, intent);
        finish();
    }
}