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
import java.util.List;
import java.util.Map;

public class ItemActivity extends AppCompatActivity {

    public TextView item_number, ingredientname;
    public ImageView image;
    public Button see_recipes;
    String diet;
    List<RecipeEntity> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        diet= getIntent().getStringExtra("diet");

        item_number = findViewById(R.id.item_number);
        String result= getIntent().getStringExtra("item_number");
        item_number.setText(result);

        //map which maps product code to ingredient name
        Map<String, String> map= new HashMap<String, String>();
        map.put("9781911223139", "banana");



        String ingredient= map.get(result);


       if(ingredient== "banana") {
           image = (ImageView) findViewById(R.id.image);
           image.setImageResource(R.drawable.banana);
        }


        //adding to database
        RecipeEntity recipe1= new RecipeEntity("banana", "banana shake", "yes", "yes", "yes", "yes", "yes", "yes");
        RecipeDatabase.getInstance(this).recipeDao().add(recipe1);
        RecipeEntity recipe2= new RecipeEntity("banana", "banana cake", "yes", "no", "yes", "yes", "yes", "yes");
        RecipeDatabase.getInstance(this).recipeDao().add(recipe2);

        if(diet=="Vegan"){
           results= RecipeDatabase.getInstance(this).recipeDao().searchvegan(ingredient);
        }
        else {
           results= RecipeDatabase.getInstance(this).recipeDao().search(ingredient);
        }
        ingredientname= findViewById(R.id.ingredientname);
        ingredientname.setText(results.get(0).getKeyProduct());

        see_recipes= (Button) findViewById(R.id.see_recipes);
        see_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ItemActivity.this, RecipesListActivity.class);
                intent.putExtra("ingredient", ingredient);
                intent.putExtra("diet", diet);
                startActivity(intent);
            }
        });
    }


}