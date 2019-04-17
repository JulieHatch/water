package com.example.waterpack;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddWater extends AppCompatActivity {
    // set variables
    String tag                  = "Add_Water";
    final String MY_PREFS_NAME  = "MyPrefsFile";

    Button   add_custom,
             add_8,
             add_16,
             add_32;
    TextView total_water;
    EditText custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);
        final SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        final SharedPreferences prefs         = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor.putFloat("waterToday", 0);
        editor.apply();

        // set the variables to their correct positions
        add_8       = findViewById(R.id.add_8oz_water_button);
        add_16      = findViewById(R.id.add_16oz_water_button);
        add_32      = findViewById(R.id.add_32oz_water_button);
        add_custom  = findViewById(R.id.add_custom_water_button);
        total_water = findViewById(R.id.total_water_today);
        custom      = findViewById(R.id.add_custom_water);

        // ADD 8 OZ TO DAILY INTAKE TOTAL
        add_8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                float total = prefs.getFloat("waterToday", 0) + 8;
                editor.putFloat("waterToday", total);
                editor.apply();
                total_water.setText(String.valueOf(total));
            }
        });

        // ADD 16 OZ TO DAILY INTAKE TOTAL
        add_16.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                float total = prefs.getFloat("waterToday", 0) + 16;
                editor.putFloat("waterToday", total);
                editor.apply();
                total_water.setText(String.valueOf(total));
            }
        });

        // ADD 32 OZ TO DAILY INTAKE TOTAL
        add_32.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                float total = prefs.getFloat("waterToday", 0) + 32;
                editor.putFloat("waterToday", total);
                editor.apply();
                total_water.setText(String.valueOf(total));
            }
        });

        // ADD CUSTOM AMOUNT OF WATER TO DAILY INTAKE TOTAL
        add_custom.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                float custom_amount = Float.parseFloat(custom.getText().toString());
                float total = prefs.getFloat("waterToday", 0) + custom_amount;
                editor.putFloat("waterToday", total);
                editor.apply();
                total_water.setText(String.valueOf(total));
            }
        });

    }
}
