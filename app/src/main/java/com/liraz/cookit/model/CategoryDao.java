package com.liraz.cookit.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDao
{
    @Query("select * from Category")
    LiveData<List<Category>> getAllRecipes();

    //inserting and updating
    //... is used when we don't know how many arguments will pass..it can be 0 category, 1 or more...
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCategories(Category...categories);

    @Delete
    void deleteCategories(Category category);

    @Query("select exists(select * from Category where categoryId = :categoryId)")
    boolean isCategoryExists(String categoryId);

    @Query("delete from Category where categoryId = :categoryId")
    void deleteByCategoryId(String categoryId);

}

