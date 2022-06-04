package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScannerActivity extends AppCompatActivity {

    public static TextView resulttextview;
    Button scanbutton, view_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        resulttextview = findViewById(R.id.barcodetextview);
        scanbutton = findViewById(R.id.buttonscan);

        scanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
            }
        });

        view_item= findViewById(R.id.view_item);
        view_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= resulttextview.getText().toString();
                Intent intent= new Intent(getApplicationContext(), ItemActivity.class);
                intent.putExtra("item_number", message);
                startActivity(intent);
            }
        });

    }
}