package com.example.fooding;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void add (RecipeEntity recipeEntity);

    @Query("SELECT * FROM recipes WHERE keyProduct=(:productname)")
    List<RecipeEntity> search(String productname);

    @Query("SELECT * FROM recipes WHERE keyProduct=(:productname) AND vegan='yes'")
    List<RecipeEntity> searchvegan(String productname);
}
