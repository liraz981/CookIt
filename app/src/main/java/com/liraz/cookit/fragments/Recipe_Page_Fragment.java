package com.liraz.cookit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liraz.cookit.R;
import com.liraz.cookit.model.Recipe;


public class Recipe_Page_Fragment extends Fragment
{
    Recipe recipe;
    View view;
    Button edit;
    TextView categoryTitle;
    TextView recipeName;
    TextView ingredientsTitle;
    TextView ingredientsList;
    TextView instructionTitle;
    TextView instructionList;
    ImageButton recImg;


    public Recipe_Page_Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recipe_page, container, false);

        edit = view.findViewById(R.id.Edit_rec_btn);
        categoryTitle = view.findViewById(R.id.Category_title);
        recipeName = view.findViewById(R.id.Rec_Name_txt);
        ingredientsTitle = view.findViewById(R.id.Ingredients_title);
        ingredientsList = view.findViewById(R.id.ingredients_list_txt);
        instructionTitle = view.findViewById(R.id.Instructions_title);
        instructionList = view.findViewById(R.id.instructions_list_txt);
        recImg = view.findViewById(R.id.Rec_img_btn);


        //recipe = Recipe_Page_FragmentArgs.fromBundle(getArguments()).getRecipe();
        if (recipe !=null){

            categoryTitle.setText(recipe.categoryId);
            recipeName.setText(recipe.recipeName);
            ingredientsList.setText(recipe.recIngredients);
            instructionList.setText(recipe.recContent);

        }















        return view;
    }
}