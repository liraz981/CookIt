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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.liraz.cookit.MyApplication;
import com.liraz.cookit.R;
import com.liraz.cookit.model.Model;
import com.liraz.cookit.model.Recipe;
import com.liraz.cookit.model.StorageModel;
import com.liraz.cookit.model.User;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;

public class NewRecipeFragment extends Fragment
{
    View view;
    EditText recipeTitleInput;
    EditText recipeIngredientsInput;
    EditText recipeInstructionsInput;
    EditText address;
    ImageView addImage;
    Spinner chooseCategory;
    Uri addImageUri;
    Bitmap addImageBitmap;
    static int REQUEST_CODE = 1;

    public NewRecipeFragment()
    {
        //Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_new_recipe, container, false);
        addImage = view.findViewById(R.id.newRecipe_add_img_icon_activity_imageView);
        recipeTitleInput = view.findViewById(R.id.new_recipe_fragment_title_text_view);
        recipeIngredientsInput = view.findViewById(R.id.new_recipe_fragment_Ingredients_edit_text);
        recipeInstructionsInput = view.findViewById(R.id.new_recipe_fragment_Instructions_edit_text);
        chooseCategory = (Spinner) view.findViewById(R.id.planets_spinner);
        address = view.findViewById(R.id.register_activity_address_edit_text);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MyApplication.context,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseCategory.setAdapter(adapter);

        addImage.setOnClickListener((view)->{chooseImageFromGallery();});

        Button uploadBtn = view.findViewById(R.id.new_recipe_fragment_upload_btn);
        uploadBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (addImageUri != null && recipeTitleInput != null && recipeIngredientsInput != null&& recipeInstructionsInput != null && address != null)
                    saveRecipe();
                else
                    Toast.makeText(getContext(), "Please fill all fields and add a photo", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    void saveRecipe()
    {
        final Recipe newRecipe = generateNewRecipe();

        StorageModel.uploadImage(addImageBitmap, new StorageModel.Listener()
        {
            @Override
            public void onSuccess(String url) {
                newRecipe.recipeImgUrl = url;
                Model.instance.addRecipe(newRecipe, new Model.Listener<Boolean>() {
                    @Override
                    public void onComplete(Boolean data)
                    {
                        NavController navCtrl = Navigation.findNavController(view);
                        navCtrl.navigateUp();
                    }
                });
            }

            @Override
            public void onFail()
            {
                Snackbar.make(view, "Failed to create post recipe and save it in databases", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private Recipe generateNewRecipe()
    {
        Recipe newRecipe = new Recipe();
        newRecipe.recipeId = UUID.randomUUID().toString();
        newRecipe.recipeName = recipeTitleInput.getText().toString();
        newRecipe.recIngredients = recipeIngredientsInput.getText().toString();
        newRecipe.recContent = recipeInstructionsInput.getText().toString();
        newRecipe.recipeImgUrl = null;
        newRecipe.userId = User.getInstance().userId;
        newRecipe.recipeImgUrl = User.getInstance().profileImageUrl;
        newRecipe.username = User.getInstance().userUsername;
        newRecipe.categoryId = chooseCategory.getSelectedItem().toString();
        return newRecipe;
    }

    void chooseImageFromGallery()
    {
        try{
            Intent openGalleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            openGalleryIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

            startActivityForResult(openGalleryIntent, REQUEST_CODE);
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), "New post recipe Page: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getData() != null && data != null && resultCode == RESULT_OK)
        {
            addImageUri = data.getData();
            addImage.setImageURI(addImageUri);
            addImageBitmap = uriToBitmap(addImageUri);
        }
        else {
            Toast.makeText(getActivity(), "No image was selected", Toast.LENGTH_SHORT).show();
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
