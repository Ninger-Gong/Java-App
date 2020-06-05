package com.example.javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detailsActivity extends AppCompatActivity {
    private static final String TAG = "detailsActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent thisIntent = getIntent();
        String message = thisIntent.getStringExtra("secondaryCategory");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
