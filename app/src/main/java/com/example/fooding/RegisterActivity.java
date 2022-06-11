package com.example.fooding;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText username, password, email, diabetes;
    Spinner spinner_diet;
    Button register;
    Button login;

    //notification
    public static final String CHANNEL_ID="My channel";
    public static final int NOT_ID=1;
    //public boolean autoCancel = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        diabetes = findViewById(R.id.diabetes);
        spinner_diet = findViewById(R.id.spinner_diet);
        register = findViewById(R.id.register_button);
        login= findViewById(R.id.login_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating User entity
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(username.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setEmail(email.getText().toString());
                userEntity.setDiabetes(diabetes.getText().toString());
                userEntity.setDiet(spinner_diet.getSelectedItem().toString());

                //channel for notification
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel= new NotificationChannel(CHANNEL_ID, "My custom channel", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager=getSystemService(NotificationManager.class);

                    manager.createNotificationChannel(channel);
                }

                if (validateInput(userEntity)) {
                    //Do insert operation
                    UserDatabase userDatabase= UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao= userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register user
                           userDao.registerUser(userEntity);
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   //Toast.makeText(getApplicationContext(), "User registered!", Toast.LENGTH_LONG).show();

                                   //notification

                                   Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                                   PendingIntent pendingIntent= PendingIntent.getActivity(RegisterActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);

                                   NotificationCompat.Builder builder=new NotificationCompat.Builder(RegisterActivity.this,CHANNEL_ID );

                                   builder.setContentTitle("FOODING - Your way to a healthier diet")
                                           .setContentText("You are now registered! Enjoy your journey with us.")
                                           .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                                           //.setAutoCancel(true)
                                           .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                           .setColor(Color.RED)
                                           .addAction(R.drawable.ic_baseline_snooze_24, "LOGIN", pendingIntent);



                                   NotificationManagerCompat managerCompat = NotificationManagerCompat.from(RegisterActivity.this);
                                   managerCompat.notify(NOT_ID, builder.build());



                               }
                           });
                        }
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class).putExtra("diet", spinner_diet.getSelectedItem().toString()));
            }
        });


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner_diet);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Vegan");
        categories.add("Vegetarian");
        categories.add("Pescatarian");
        categories.add("Gluten-free");
        categories.add("Dairy-free");
        categories.add("No special preferences");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }



    private Boolean validateInput(UserEntity userEntity){
        if(userEntity.getUsername().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getEmail().isEmpty() || userEntity.getDiet().isEmpty() || userEntity.getDiabetes().isEmpty()){
            return false;
        }
        return true;
    }

   @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}


    
