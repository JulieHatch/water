package com.example.waterpack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // declare variables
    Button button,
           addWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set variables
        button   = findViewById(R.id.button);
        addWater = findViewById(R.id.addWater);

        // When Add Water Button is clicked this function is called
        addWater.setOnClickListener(new View.OnClickListener() {
            // When Create Button is clicked this function is called
            @Override
            public void onClick(View v) {
                Log.i("Add Water Button Push", "Changing to AddWater");
                startActivity(new Intent(MainActivity.this, AddWater.class));
            }
        });

        // When Create User Button is clicked this function is called
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("New User Button Push", "Changing to New_User");
                startActivity(new Intent(MainActivity.this, New_User.class));
            }
        });
    }
}
