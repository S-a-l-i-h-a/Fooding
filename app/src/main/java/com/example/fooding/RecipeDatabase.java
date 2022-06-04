package com.example.fooding;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RecipeEntity.class}, version = 1)
public abstract class RecipeDatabase extends RoomDatabase {

    public abstract RecipeDao recipeDao();
    private static RecipeDatabase INSTANCE;

    public static RecipeDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, RecipeDatabase.class, "recipe_database").allowMainThreadQueries().build();

        }
        return INSTANCE;
    }



}
