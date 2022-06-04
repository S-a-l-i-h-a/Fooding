package com.example.fooding;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ItemActivity extends AppCompatActivity {

    public TextView item_number, ingredientname;
    public ImageView image;
    public Button see_recipes;

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

        //zasto ne radi?
       /* if(ingredient== "banana") {
            image = (ImageView) findViewById(R.id.image);
            Resources res = getResources();
            image.setImageDrawable(res.getDrawable(R.drawable.banana));
        } */


        //adding to database
        RecipeEntity recipe1= new RecipeEntity(1, "bananas", "yes", "yes", "yes", "yes", "yes", "yes");
        RecipeDatabase.getInstance(this).recipeDao().add(recipe1);

        RecipeEntity result1= RecipeDatabase.getInstance(this).recipeDao().search(ingredient);

        ingredientname= findViewById(R.id.ingredientname);
        ingredientname.setText(result1.getDairyfree());

        see_recipes= (Button) findViewById(R.id.see_recipes);
        see_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ItemActivity.this, RecipesListActivity.class);
                intent.putExtra("ingredient", ingredient);
                startActivity(intent);
            }
        });
    }


}