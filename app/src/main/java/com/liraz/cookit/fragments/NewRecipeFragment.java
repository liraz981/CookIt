package com.liraz.cookit.fragments;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.liraz.cookit.R;

public class NewRecipeFragment {
    View view;
    EditText recipeTitleInput;
    EditText recipeIngredientsInput;
    EditText recipeInstructionsInput;
    EditText address;
    Button addImage;
    Spinner chooseCategory;
    Uri addImageUri;
    Bitmap addImageBitmap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_new_recipe, container, false);
        addImage = view.findViewById(R.id.new_recipe_fragment_add_image_btn);
        recipeTitleInput = view.findViewById(R.id.new_recipe_fragment_title_text_view);
        recipeIngredientsInput = view.findViewById(R.id.new_recipe_fragment_Ingredients_edit_text);
        recipeInstructionsInput = view.findViewById(R.id.new_recipe_fragment_Instructions_edit_text);
        chooseCategory = (Spinner) view.findViewById(R.id.new_recipe_fragment_category_spinner);
        address = view.findViewById(R.id.register_activity_address_edit_text);

        return null;
    }
}




//    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
 //   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//            R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
//spinner.setAdapter(adapter);

