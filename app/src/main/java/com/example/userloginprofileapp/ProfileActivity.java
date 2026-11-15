package com.example.userloginprofileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileName, tvProfileEmail, tvProfileMobile;
    Button btnLogout;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileName = findViewById(R.id.tvProfileName);
        tvProfileEmail = findViewById(R.id.tvProfileEmail);
        tvProfileMobile = findViewById(R.id.tvProfileMobile);
        btnLogout = findViewById(R.id.btnLogout);
        db = new DatabaseHelper(this);

        final SharedPreferences prefs = getSharedPreferences("session", MODE_PRIVATE);
        String email = prefs.getString("email", "");

        // read the logged in user from the database
        Cursor cursor = db.getUserDetails(email);
        if (cursor.moveToFirst()) {
            tvProfileName.setText("Name: " + cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_NAME)));
            tvProfileEmail.setText("Email: " + cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_EMAIL)));
            tvProfileMobile.setText("Mobile: " + cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_MOBILE)));
        } else {
            Toast.makeText(this, "Unable to load profile", Toast.LENGTH_SHORT).show();
        }
        cursor.close();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().clear().apply(); // remove the session
                Toast.makeText(ProfileActivity.this, "Logged out", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
