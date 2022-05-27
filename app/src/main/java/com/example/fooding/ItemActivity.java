package com.example.fooding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        TextView item_number= findViewById(R.id.item_number);
        String item_number2= getIntent().getStringExtra("item_number");
        item_number.setText(item_number2);
    }


}
