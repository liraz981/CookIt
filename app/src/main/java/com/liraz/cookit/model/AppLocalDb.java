package com.liraz.cookit.model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.liraz.cookit.MyApplication;

@Database(entities = {Recipe.class ,Category.class}, version = 1)
abstract class AppLocalDbRepository extends RoomDatabase {
    public abstract RecipeDao RecipeDao();
    public abstract CategoryDao CategoryDao();
}

public class AppLocalDb {

    static public AppLocalDbRepository db =
            Room.databaseBuilder(
                    MyApplication.context,
                    AppLocalDbRepository.class,
                    "AppLocalDb.db")
                    .fallbackToDestructiveMigration()
                    .build();

}
