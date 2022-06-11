package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    EditText email, username, password, diabetes, diet;
    TextView name;
    private String getEmail;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.username);
        username = findViewById(R.id.user_username);
        email = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);
        diabetes = findViewById(R.id.diabetes_info);
        diet = findViewById(R.id.diet_info);

        /*Bundle extras = getIntent().getExtras();
        getEmail = extras.getString(LoginActivity.EXTRA_USER_EMAIL);*/
        /*UserEntity user = UserDatabase.getUserDatabase().userDao().getUserByEmail(email);
        username.setText(user.getUsername());
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        diabetes.setText(user.getDiabetes());
        diet.setText(user.getDiet());
        name.setText(user.getUsername());*/

       /* Button button = findViewById(R.id.changePass_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = password.getText().toString();
                AppDatabase.getInstance(getActivity()).signupDao().updatePassword(newPassword,getEmail);
                Toast.makeText(getActivity(), "Password changed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }*/

}

}







