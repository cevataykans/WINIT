package com.example.user.winit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    Button header;
    Button enter;
    String answer;
    TextView questionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        header = (Button) findViewById(R.id.forgotHeader);
        header.setEnabled(false);

        questionDisplay = (TextView) findViewById(R.id.questionDisplay);
        //questionDisplay.setText( CreateProfile2.readUserProfile());

        enter = (Button) findViewById(R.id.enterAnswer);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText answerField = (EditText) findViewById(R.id.answerField);
                answer = answerField.getText().toString();

                /**
                if ( answer.equals( CreateProfile2.readUserProfile() ) )
                {
                    Intent goToResetPassword;
                    goToResetPassword = new Intent( ForgotPassword.this, ResetPassword.class);

                    startActivity( goToResetPassword);
                }
                else
                {
                    Toast.makeText( ForgotPassword.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }
                 */
            }
        });

    }
}
