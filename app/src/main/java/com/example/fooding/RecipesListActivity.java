package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecipesListActivity extends AppCompatActivity {
  // public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String EXTRA_VEGAN = "EXTRA_VEGAN";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        listView = findViewById(R.id.list_view_container);
        String ingredient= getIntent().getStringExtra("ingredient");
        RecipeListViewAdapter recipeListViewAdapter= new RecipeListViewAdapter(getRecipes(ingredient),this);
        listView.setAdapter(recipeListViewAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            RecipeEntity recipe = (RecipeEntity) parent.getItemAtPosition(position);
            Intent intent = new Intent(RecipesListActivity.this,RecipeDetails.class);
          //  intent.putExtra(EXTRA_IMAGE,recipe.getImageResId());
            intent.putExtra(EXTRA_ID, recipe.getId());
            intent.putExtra(EXTRA_VEGAN, recipe.getVegan());
            startActivity(intent);
        }
    };


    private List<RecipeEntity> getRecipes(String ingredient){
        List<RecipeEntity> recipeList=new ArrayList<>();
        recipeList.add(RecipeDatabase.getInstance(this).recipeDao().search(ingredient));
        return recipeList;
    }

}
