package com.liraz.cookit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.liraz.cookit.R;

public class MainFragment extends Fragment
{

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
        mains = view.findViewById(R.id.main_fragment_mains_image_view);
        salads = view.findViewById(R.id.main_fragment_salads_image_view);
        healthy_food = view.findViewById(R.id.main_fragment_healthy_food_image_view);
        cookies = view.findViewById(R.id.main_fragment_cookies_image_view);
        desserts = view.findViewById(R.id.main_fragment_deserts_image_view);

        appetizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Appetizers");
                Navigation.findNavController(view).navigate(action);
            }
        });

        mains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Mains");
                Navigation.findNavController(view).navigate(action);
            }
        });

        salads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Salads");
                Navigation.findNavController(view).navigate(action);
            }
        });

        healthy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Healthy food");
                Navigation.findNavController(view).navigate(action);
            }
        });

        cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Cookies");
                Navigation.findNavController(view).navigate(action);
            }
        });

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionCategoryToRecList action = MainFragmentDirections.actionCategoryToRecList("Desserts");
                Navigation.findNavController(view).navigate(action);
            }
        });


        /*Button btn = view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_maps);
            }
        });*/


        return view;
    }
}