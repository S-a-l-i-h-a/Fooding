package com.example.fooding;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ItemActivity extends AppCompatActivity {

    public TextView item_number, ingredientname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        item_number = findViewById(R.id.item_number);
        String result= getIntent().getStringExtra("item_number");
        item_number.setText(result);

        //map which maps product code to ingredient name
        Map<String, String> map= new HashMap<String, String>();
        map.put("9781911223139", "bananas");


        String ingredient= map.get(result);

        //initializing database
       // RecipeDatabase recipeDatabase= RecipeDatabase.getRecipeDatabase(getApplicationContext());
       // RecipeDao recipeDao= recipeDatabase.recipeDao();

        //adding to database
        RecipeEntity recipe1= new RecipeEntity(1, "bananas", "yes", "yes", "yes", "yes", "yes", "yes");
        RecipeDatabase.getInstance(this).recipeDao().add(recipe1);

        RecipeEntity result1= RecipeDatabase.getInstance(this).recipeDao().search(ingredient);

        ingredientname= findViewById(R.id.ingredientname);
        ingredientname.setText(result1.getDairyfree());



    }


}
