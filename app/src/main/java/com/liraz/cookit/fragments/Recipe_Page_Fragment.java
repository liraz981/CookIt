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


public class Recipe_Page_Fragment extends Fragment
{
    View view;
    Button myProfile;
    Button home;
    Button edit;
    TextView categoryTitle;
    TextView categoryName;
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
        myProfile = view.findViewById(R.id.Profile_page_btn);
        home = view.findViewById(R.id.home_page_btn);
        edit = view.findViewById(R.id.Edit_rec_btn);
        categoryTitle = view.findViewById(R.id.Category_title);
        categoryName = view.findViewById(R.id.Cat_Name_txt);
        ingredientsTitle = view.findViewById(R.id.Ingredients_title);
        ingredientsList = view.findViewById(R.id.ingredients_list_txt);
        instructionTitle = view.findViewById(R.id.Instructions_title);
        instructionList = view.findViewById(R.id.instructions_list_txt);
        recImg = view.findViewById(R.id.Rec_img_btn);

        return view;
    }
}