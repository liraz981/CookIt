package com.liraz.cookit.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {

    @PrimaryKey
    @NonNull
    public String recipeId;
    public String recipeName;
    public String categoryId;
    public String recIngredients;
    public String recContent;
    public String postImgUrl;
    public String userId;
    public String username;


    public Recipe() {
        recipeId = "";
        recipeName = "";
        categoryId = "";
        recIngredients = "";
        recContent = "";
        postImgUrl = "";
        userId = "";
        username = "";
    }

    public Recipe(String recipeId, String recipeName, String categoryId, String recIngredients, String recContent, String postImgUrl, String userId, String username) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.categoryId = categoryId;
        this.recIngredients = recIngredients;
        this.recContent = recContent;
        this.postImgUrl = postImgUrl;
        this.userId = userId;
        this.username = username;
    }

    @NonNull
    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecIngredients() {
        return recIngredients;
    }

    public void setRecIngredients(String recIngredients) {
        this.recIngredients = recIngredients;
    }

    public String getRecContent() {
        return recContent;
    }

    public void setRecContent(String recContent) {
        this.recContent = recContent;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
