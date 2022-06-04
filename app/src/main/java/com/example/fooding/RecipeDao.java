package com.example.fooding;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RecipeDao {

    @Insert
    void add (RecipeEntity recipeEntity);

    @Query("SELECT * FROM recipes WHERE keyProduct=(:productname)")
    RecipeEntity search(String productname);
}
