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

    private ListView listView;
    String diet;
    List<RecipeEntity> recipeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        listView = findViewById(R.id.list_view_container);
        String ingredient= getIntent().getStringExtra("ingredient");
        diet= getIntent().getStringExtra("diet");
        String vegan= "Vegan";
        if(diet!=null && diet.equals(vegan)) {
            recipeList = getRecipesVegan(ingredient);
        }
        else{
            recipeList= getRecipes(ingredient);
        }

        RecipeListViewAdapter recipeListViewAdapter= new RecipeListViewAdapter(recipeList,this);
        listView.setAdapter(recipeListViewAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            RecipeEntity recipe = (RecipeEntity) parent.getItemAtPosition(position);
            Intent intent = new Intent(RecipesListActivity.this,RecipeDetails.class);
            intent.putExtra("recipe_name", recipe.getName());
            startActivity(intent);
        }
    };


    private List<RecipeEntity> getRecipes(String ingredient){
        List<RecipeEntity> recipeList=new ArrayList<>();
        recipeList= RecipeDatabase.getInstance(this).recipeDao().search(ingredient);
        return recipeList;
    }

    private List<RecipeEntity> getRecipesVegan(String ingredient){
        List<RecipeEntity> recipeList=new ArrayList<>();
        recipeList= RecipeDatabase.getInstance(this).recipeDao().searchvegan(ingredient);
        return recipeList;
    }

}
