package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        imageView = findViewById(R.id.ingredient_image);
        title = findViewById(R.id.recipe_title);
        description = findViewById(R.id.recipe_description);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            setTitle("Banana");
            imageView.setImageResource(R.drawable.banana);
            title.setText(extras.getString(RecipesListActivity.EXTRA_ID));
          //  description.setText(extras.getString(RecipesListActivity.EXTRA_VEGAN));
        }
    }
}
