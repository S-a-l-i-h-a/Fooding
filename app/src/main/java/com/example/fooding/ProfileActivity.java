package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {

    EditText email, username, password, diabetes, diet;
    TextView name;
    String getEmail, getUsername, getPassword, getDiabetes, getDiet;


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name2);
        username = findViewById(R.id.user_username);
        email = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);
        diabetes = findViewById(R.id.diabetes_info);
        diet = findViewById(R.id.diet_info);

        getEmail= getIntent().getStringExtra("email");
        getUsername= getIntent().getStringExtra("username");
        getPassword= getIntent().getStringExtra("password");
        getDiet= getIntent().getStringExtra("diet");
        getDiabetes= getIntent().getStringExtra("diabetes");


        username.setHint(getUsername);
        email.setHint(getEmail);
        password.setHint("************");
        diabetes.setHint(getDiabetes);
        diet.setHint(getDiet);
        name.setText(getUsername);

        Button button = findViewById(R.id.viewPass_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setHint(getPassword);
            }
        });
    }
}









