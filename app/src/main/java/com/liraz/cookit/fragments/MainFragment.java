package com.liraz.cookit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.liraz.cookit.R;
import com.liraz.cookit.model.Category;

public class MainFragment extends Fragment {

    Button btn;
    //ImageView[] categories;
    ImageView appetizers;
    ImageView mains;
    ImageView salads;
    ImageView healthy_food;
    ImageView cookies;
    ImageView desserts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        appetizers = view.findViewById(R.id.main_fragment_appetizers_image_view);
        mains = view.findViewById(R.id.main_fragment_main_logo_image_view);
        salads = view.findViewById(R.id.main_fragment_salads_image_view);
        healthy_food = view.findViewById(R.id.main_fragment_healthy_food_image_view);
        cookies = view.findViewById(R.id.main_fragment_cookies_image_view);
        desserts = view.findViewById(R.id.main_fragment_deserts_image_view);

        appetizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("appetizers");
                Navigation.findNavController(view).navigate(action);
            }
        });

        mains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("mains");
                Navigation.findNavController(view).navigate(action);
            }
        });

        salads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("salads");
                Navigation.findNavController(view).navigate(action);
            }
        });

        healthy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("healthy_food");
                Navigation.findNavController(view).navigate(action);
            }
        });

        cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("cookies");
                Navigation.findNavController(view).navigate(action);
            }
        });

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("desserts");
                Navigation.findNavController(view).navigate(action);
            }
        });



        btn = view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_newRecipeFragment3);
            }
        });


        return view;
    }
}