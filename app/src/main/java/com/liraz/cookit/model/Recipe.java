package com.liraz.cookit.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Recipe implements Serializable {

    @PrimaryKey
    @NonNull
    public String recipeId;
    public String recipeName;
    public String categoryId;
    public String recIngredients;
    public String recContent;
    public String recipeImgUrl;
    public String userId;
    public String username;
    public long lastUpdated;
    public double lat;
    public double lon;


    public Recipe() {
        recipeId = "";
        recipeName = "";
        categoryId = "";
        recIngredients = "";
        recContent = "";
        recipeImgUrl = "";
        userId = "";
        username = "";
        lastUpdated = 0;
    }

    public Recipe(String recipeId, String recipeName, String categoryId, String recIngredients, String recContent, String recipeImgUrl, String userId, String username) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.categoryId = categoryId;
        this.recIngredients = recIngredients;
        this.recContent = recContent;
        this.recipeImgUrl = recipeImgUrl;
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

    public String getRecipeImgUrl() {
        return recipeImgUrl;
    }

    public void setRecipeImgUrl(String recipeImgUrl) {
        this.recipeImgUrl = recipeImgUrl;
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

    public long getLastUpdated() {
        return lastUpdated;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
