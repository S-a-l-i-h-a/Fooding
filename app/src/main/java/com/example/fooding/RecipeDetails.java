package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    String recipe_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        recipe_name= getIntent().getStringExtra("recipe_name");

        imageView = findViewById(R.id.recipe_image);
        title = findViewById(R.id.recipe_title);
        description = findViewById(R.id.recipe_description);

        String banana_shake= "banana shake";
        if(recipe_name.equals(banana_shake)){
            setTitle(recipe_name);
            title.setText(recipe_name);

            imageView.setImageResource(R.drawable.bananashake);

            description.setText("This text should write out a recipe for a banana shake.");
        }

        else{
            setTitle(recipe_name);
            title.setText(recipe_name);

            imageView.setImageResource(R.drawable.bananacake);

            description.setText("This text should write out a recipe for a banana cake.");
        }
    }
}
