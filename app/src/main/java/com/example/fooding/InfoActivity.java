package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

public class InfoActivity extends AppCompatActivity {

    EditText whoarewe,ourmission,whyfooding,whatnext;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        whoarewe=findViewById(R.id.text_who_are_we);
        ourmission=findViewById(R.id.text_our_mission);
        whyfooding=findViewById(R.id.text_why_fooding);
        whatnext=findViewById(R.id.text_what_next);

        whoarewe.setText("Here to make your diet healthier!!!");
        ourmission.setText("Health diet, healthy life :)");
        whyfooding.setText("Why us? Join and see :)");
        whatnext.setText("Stay tuned, much more coming in the future!");


    }
}