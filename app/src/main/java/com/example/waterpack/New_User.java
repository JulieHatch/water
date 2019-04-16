package com.example.waterpack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class New_User extends AppCompatActivity {

    String tag = "New_User";
    // A new user
    User     new_user;
    // User fields
    EditText username,
             weight,
             height,
             age,
             gender;
    Button   calculate;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__user);
        // set vsrisbles for shared prferences
        final String MY_PREFS_NAME            = "MyPrefsFile";
        final SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        // Set user fields
        title     = findViewById(R.id.title);
        username  = findViewById(R.id.username);
        weight    = findViewById(R.id.weight);
        height    = findViewById(R.id.height);
        gender    = findViewById(R.id.gender);
        age       = findViewById(R.id.age);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            // When Create Button is clicked this function is called
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Convert task elements to variable tyle
                String usernameAdd = username.getText().toString();
                float weightAdd    = Float.parseFloat(weight.getText().toString());
                float heightAdd    = Float.parseFloat(height.getText().toString());
                String genderAdd   = String.valueOf(gender.getText());
                float ageAdd       = Float.parseFloat(age.getText().toString());

                // Create user with user entered data
                new_user = new User(usernameAdd, genderAdd, weightAdd, heightAdd, ageAdd);
                editor.putString("username", usernameAdd);
                editor.putString("gender", genderAdd);
                editor.putFloat("water", new_user.getWaterPerDay());
                editor.apply();

                // Check that user was stored
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String restoredText     = prefs.getString("username", null);
                if (restoredText != null) {
                    Log.d(tag, "User added to shared preferences");
                    // If the user was stored return to MainActivity
                    startActivity(new Intent(New_User.this, MainActivity.class));
                }
                else{
                    Log.e(tag, "Unable to add user");
                }
            }
        });
    }
}

