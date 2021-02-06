package com.liraz.cookit.activities;

import com.google.firebase.auth.FirebaseAuth;
import com.liraz.cookit.R;
import com.liraz.cookit.model.ModelFirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginPageActivity extends AppCompatActivity
{

    EditText emailInput;
    EditText passwordInput;
    Button loginBtn;
    Button registerBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        firebaseAuth = firebaseAuth.getInstance();
        this.setTitle("Login");

        emailInput = findViewById(R.id.login_activity_email_edit_text);
        passwordInput = findViewById(R.id.login_activity_pass_edit_text);

        registerBtn = findViewById(R.id.login_activity_register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                toRegisterPage();
            }
        });

        loginBtn = findViewById(R.id.login_activity_login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ModelFirebase.loginUser(emailInput.getText().toString(), passwordInput.getText().toString(), new ModelFirebase.Listener<Boolean>() {
                    @Override
                    public void onComplete()
                    {
                        //להחזיר אחרי שליקוש עושה דף בית
                       // startActivity(new Intent(LoginPageActivity.this, HomeActivity.class));
                        LoginPageActivity.this.finish();
                    }

                    @Override
                    public void onFail()
                    {

                    }
                });
            }
        });


    }

    private void toRegisterPage()
    {
        Intent intent = new Intent(this, RegisterPageActivity.class);
        startActivity(intent);
    }


}
