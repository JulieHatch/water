package com.example.waterpack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            // When Create Button is clicked this function is called
            @Override
            public void onClick(View v) {
                Log.i("New User Button Push", "Changing to New_User");
                startActivity(new Intent(MainActivity.this, New_User.class));
            }
        });
    }

}
