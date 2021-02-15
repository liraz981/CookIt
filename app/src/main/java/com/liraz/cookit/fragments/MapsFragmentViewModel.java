package com.liraz.cookit.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.liraz.cookit.model.Model;
import com.liraz.cookit.model.Recipe;

import java.util.List;

public class MapsFragmentViewModel extends ViewModel {


    LiveData<List<Recipe>> liveData;

    public LiveData<List<Recipe>> getData(){
        if (liveData == null)
            liveData = Model.instance.getAllRecipes();
        return liveData;
    }

    public void refresh(Model.CompListener listener){
        Model.instance.refreshRecipesList(listener);
    }

}
