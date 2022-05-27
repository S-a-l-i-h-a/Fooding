package com.example.fooding;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        login_button= findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText= username.getText().toString();
                String passwordText= password.getText().toString();
                if (usernameText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    //Perform query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao= userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(usernameText, passwordText);
                            if (userEntity== null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                String name= userEntity.username;
                                startActivity(new Intent(LoginActivity.this, Homescreen.class).putExtra("name", name));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}