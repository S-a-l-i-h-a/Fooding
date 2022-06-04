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
    Button scanbutton, buttontoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        resulttextview = findViewById(R.id.barcodetextview);
        scanbutton = findViewById(R.id.buttonscan);
        buttontoast = findViewById(R.id.buttontoast);

        scanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
            }
        });

        buttontoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScannerActivity.this, resulttextview.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}