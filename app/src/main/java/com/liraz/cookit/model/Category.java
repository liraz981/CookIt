package com.liraz.cookit.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category
{
    @PrimaryKey
    @NonNull
    public String categoryId;
    public String categoryName;
    public String categoryImgUrl;

    public Category()
    {
        categoryId = "";
        categoryName = "";
        categoryImgUrl ="";
    }

    public Category(String categoryId, String categoryName, String categoryImgUrl)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImgUrl = categoryImgUrl;
    }

    @NonNull
    public String getCategoryId()
    {
        return categoryId;
    }

    @NonNull
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    @NonNull
    public String getCategoryName()
    {
        return categoryName;
    }

    @NonNull
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    @NonNull
    public String getCategoryImgUrl()
    {
        return categoryImgUrl;
    }

    @NonNull
    public void setCategoryImgUrl(String categoryImgUrl)
    {
        this.categoryImgUrl = categoryImgUrl;
    }
}
