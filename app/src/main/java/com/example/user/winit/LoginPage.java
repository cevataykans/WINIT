package com.example.user.winit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button signIn;
    Button createPage;
    Button help;
    Button forgotPassword;

    EditText usernameField;
    EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        signIn = (Button) findViewById(R.id.signIn);
        createPage = (Button) findViewById(R.id.createProfile);
        help = (Button) findViewById(R.id.help);
        forgotPassword = (Button) findViewById(R.id.passwordForgot);
        /**
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameField = (EditText) findViewById(R.id.usernameField);
                passwordField = (EditText) findViewById(R.id.passwordField);

                if ( usernameField.getText().toString().equals( CreateProfile1.getUsername() ) &&
                        passwordField.getText().toString().equals( CreateProfile1.getPassword() ) )
                {
                    Intent goToMainPage;
                    goToMainPage = new Intent( LoginPage.this, MainMenu.class);

                    startActivity( goToMainPage);
                }

                else
                {
                    Toast.makeText( LoginPage.this, "Wrong Information!", Toast.LENGTH_SHORT).show();
                }
            }
        });
         */
        createPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCreate;
                goToCreate = new Intent(LoginPage.this, CreateProfile1.class);
                startActivity(goToCreate);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpPop;
                helpPop = new Intent ( LoginPage.this, Pop.class);

                startActivity(helpPop);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForgotPassword;
                goToForgotPassword = new Intent( LoginPage.this, ForgotPassword.class);

                startActivity( goToForgotPassword);
            }
        });
    }
}
