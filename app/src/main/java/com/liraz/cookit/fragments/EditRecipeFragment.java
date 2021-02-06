package com.liraz.cookit.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.liraz.cookit.R;
import com.liraz.cookit.model.Model;
import com.liraz.cookit.model.Recipe;
import com.liraz.cookit.model.StorageModel;
import com.squareup.picasso.Picasso;

import java.io.FileDescriptor;
import java.io.IOException;

public class EditRecipeFragment extends Fragment
{
    View view;
    Recipe recipe;
    EditText titleInput;
    EditText addressInput;
    EditText ingredientsInput;
    EditText instructionsInput;
    Button saveChangesBtn;
    ImageView recipeImageView;
    Uri recipeImageUri;
    Bitmap recipeImgBitmap;
    static int REQUEST_CODE = 1;

    public EditRecipeFragment()
    {
        //Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_recipe, container, false);

        titleInput = view.findViewById(R.id.edit_recipe_fragment_title_text_view);
        addressInput = view.findViewById(R.id.edit_post_activity_address_edit_text);
        ingredientsInput = view.findViewById(R.id.edit_recipe_fragment_Ingredients_edit_text);
        instructionsInput = view.findViewById(R.id.edit_recipe_fragment_Instructions_edit_text);
        recipeImageView = view.findViewById(R.id.editRecipe_change_img_icon_activity_imageView);

        //recipe = recipeDetailsFragmentArgs.fromBundle(getArguments()).getPost(); אחרי שלירז תיצור להוריד
        if (recipe != null)
        {
            setEditRecipeHints();
        }

        recipeImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                chooseImageFromGallery();
            }
        });

        saveChangesBtn = view.findViewById(R.id.edit_recipe_fragment_save_changes_btn);
        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRecipe();
            }
        });

        return view;
    }

    void updateRecipe()
    {

        if (recipeImageUri != null)
        {
            StorageModel.uploadImage(recipeImgBitmap, new StorageModel.Listener() {
                @Override
                public void onSuccess(String url) {

                    Model.instance.addRecipe(generatedEditedRecipe(url), new Model.Listener<Boolean>() {
                        @Override
                        public void onComplete(Boolean data)
                        {
                            NavController navCtrl = Navigation.findNavController(view);
                            navCtrl.navigateUp();
                            navCtrl.navigateUp();
                        }
                    });
                }

                @Override
                public void onFail()
                {
                    Snackbar.make(view, "Failed to edit post", Snackbar.LENGTH_LONG).show();
                }
            });
        }
        else {
            Model.instance.addRecipe(generatedEditedRecipe(null), new Model.Listener<Boolean>() {
                @Override
                public void onComplete(Boolean data)
                {
                    NavController navCtrl = Navigation.findNavController(view);
                    navCtrl.navigateUp();
                    navCtrl.navigateUp();
                }
            });
        }

    }

    private Recipe generatedEditedRecipe(String imageUrl)
    {

        Recipe editedRecipe = recipe;
        if (titleInput.getText().toString() != null && !titleInput.getText().toString().equals(""))
            editedRecipe.recipeName = titleInput.getText().toString();
        else editedRecipe.recipeName = recipe.recipeName;
        if (ingredientsInput.getText().toString() != null && !ingredientsInput.getText().toString().equals(""))
            editedRecipe.recIngredients = ingredientsInput.getText().toString();
        else editedRecipe.recIngredients = recipe.recIngredients;
        if (instructionsInput.getText().toString() != null && !instructionsInput.getText().toString().equals(""))
            editedRecipe.recContent = instructionsInput.getText().toString();
        else editedRecipe.recContent = recipe.recContent;
        //if (addressInput.getText().toString() != null && !addressInput.getText().toString().equals(""))
      //      editedRecipe.address = addressInput.getText().toString();
    //    else editedRecipe.address = recipe.address; להחזיר כשיהיה משתנה אדרס למתכון
        if (imageUrl != null)
            editedRecipe.recipeImgUrl = imageUrl;

        return editedRecipe;
    }

    private void setEditRecipeHints()
    {
        if (recipe.recipeImgUrl != null)
        {
            Picasso.get().load(recipe.recipeImgUrl).noPlaceholder().into(recipeImageView);
        }
        titleInput.setText(recipe.recipeName);
        instructionsInput.setText(recipe.recContent);
        //addressInput.setText(recipe.); להוסיף עריכה לכתובת
        ingredientsInput.setText(recipe.recIngredients);
    }

    private void chooseImageFromGallery()
    {

        try
        {
            Intent openGalleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            openGalleryIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

            startActivityForResult(openGalleryIntent, REQUEST_CODE);
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "Edit post Page: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getData() != null && data != null){
            recipeImageUri = data.getData();
            recipeImageView.setImageURI(recipeImageUri);
            recipeImgBitmap = uriToBitmap(recipeImageUri);

        }
        else {
            Toast.makeText(getContext(), "No image was selected", Toast.LENGTH_SHORT).show();
        }
    }

    private Bitmap uriToBitmap(Uri selectedFileUri)
    {
        try {
            ParcelFileDescriptor parcelFileDescriptor = getContext().getContentResolver().openFileDescriptor(selectedFileUri, "r");
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            parcelFileDescriptor.close();
            return image;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
