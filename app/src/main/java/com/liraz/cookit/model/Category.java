package com.liraz.cookit.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Category
{
    @PrimaryKey
    @NonNull
    public String categoryId;
    public String categoryName;
    public String categoryImgUrl;
    public long lastUpdated;

    public Category()
    {
        categoryId = "";
        categoryName = "";
        categoryImgUrl ="";
        lastUpdated = 0;
    }

    public Category(String categoryId, String categoryName, String categoryImgUrl)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImgUrl = categoryImgUrl;
    }

    public static Map<String, Object> toMap(Category category)
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoryId", category.categoryId);
        map.put("categoryName", category.categoryName);
        map.put("categoryImgUrl", category.categoryImgUrl);
        map.put("lastUpdated", FieldValue.serverTimestamp());
        return map;
    }

    private static Category fromMap(Map<String, Object> json)
    {
        Category newCategory = new Category();
        newCategory.categoryId = (String) json.get("categoryId");
        newCategory.categoryName = (String) json.get("categoryName");
        newCategory.categoryImgUrl = (String) json.get("categoryImgUrl");

        Timestamp ts = (Timestamp)json.get("lastUpdated");
        if (ts != null)
            newCategory.lastUpdated = ts.getSeconds();
        return newCategory;
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

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
