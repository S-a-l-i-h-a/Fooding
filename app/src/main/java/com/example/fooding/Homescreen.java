package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Homescreen extends AppCompatActivity {

    TextView tName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        tName = findViewById(R.id.name);
        String name= getIntent().getStringExtra("name");
        tName.setText(name);
    }
}