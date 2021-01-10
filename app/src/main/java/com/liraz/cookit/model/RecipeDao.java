package com.liraz.cookit.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("select * from Recipe")
    LiveData<List<Recipe>> getAllRecipes();

    //inserting and updating
    //... is used when we don't know how many arguments will pass..it can be 0 Recipe, 1 or more...
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllRecipes(Recipe...recipes);

    @Delete
    void deleteRecipe(Recipe recipe);

    @Query("select exists(select * from Recipe where recipeId = :recipeId)")
    boolean isRecipeExists(String recipeId);

    @Query("delete from Recipe where recipeId = :recipeId")
    void deleteByRecipeId(String recipeId);

}
