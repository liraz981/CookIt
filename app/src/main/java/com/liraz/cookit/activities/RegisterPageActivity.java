package com.liraz.cookit.activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.liraz.cookit.R;
import com.liraz.cookit.model.ModelFirebase;

public class RegisterPageActivity extends AppCompatActivity
{
    TextView title;
    EditText userName;
    ImageView profileImageView;
    EditText email;
    EditText password;
    Button registerBtn;
    Button loginBtn;
    Uri profileImageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        userName = findViewById(R.id.register_activity_username_edit_text);
        password = findViewById(R.id.register_activity_pass_edit_text);
        email = findViewById(R.id.register_activity_email_edit_text);
        profileImageView = findViewById(R.id.register_add_img_icon_activity_imageView);
        registerBtn = findViewById(R.id.register_activity_register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ModelFirebase.registerUserAccount(userName.getText().toString(), password.getText().toString(), email.getText().toString(), profileImageUri, new ModelFirebase.Listener<Boolean>() {
                    @Override
                    public void onComplete()
                    {
                        RegisterPageActivity.this.finish();
                    }

                    @Override
                    public void onFail()
                    {

                    }
                });
            }
        });

    }

}
