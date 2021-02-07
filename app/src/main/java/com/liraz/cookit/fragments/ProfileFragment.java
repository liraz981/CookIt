package com.liraz.cookit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.liraz.cookit.R;
import com.liraz.cookit.model.User;
import com.liraz.cookit.model.Utils;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment
{
    TextView userUsername;
    TextView userEmail;
    ImageView userProfileImage;
    Button editProfileBtn;
    Button myRecipesBook;

    public ProfileFragment()
    {
        //Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        userUsername = view.findViewById(R.id.profile_fragment_username_text_view);
        userEmail = view.findViewById(R.id.profile_fragment_email_text_view);
        userProfileImage = view.findViewById(R.id.profile_fragment_profile_image_view);

        editProfileBtn = view.findViewById(R.id.profile_fragment_edit_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                toEditProfilePage();
            }
        });

        myRecipesBook = view.findViewById(R.id.profile_fragment_my_recipes_book_btn);
        myRecipesBook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        setUserProfile();
        return view;
    }

    public void setUserProfile()
    {
        userUsername.setText(User.getInstance().userUsername);
        userEmail.setText(User.getInstance().userEmail);

        if (User.getInstance().profileImageUrl != null)
        {
            Picasso.get().load(User.getInstance().profileImageUrl).noPlaceholder().into(userProfileImage);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private void toEditProfilePage()
    {
        NavController navCtrl = Navigation.findNavController(getActivity(), R.id.main_nav_host);
//        NavDirections directions = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment();
//        navCtrl.navigate(directions);
    }



}
