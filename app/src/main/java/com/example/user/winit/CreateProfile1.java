package com.example.user.winit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfile1 extends AppCompatActivity {

    protected static FirebaseDatabase database;

    static Spinner spinner;
    ArrayAdapter<String> adapter;
    Button next;
    EditText enteredUsername;
    EditText enteredPassword;
    EditText enteredAnswer;
    static String test1;
    static String test2;
    static String test3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile1);

        database = FirebaseDatabase.getInstance();

        enteredUsername = (EditText) findViewById(R.id.createUsername);


        enteredPassword = (EditText) findViewById(R.id.createPassword);


        spinner = (Spinner) findViewById(R.id.spinner);
        adapter =  new ArrayAdapter<String>( CreateProfile1.this,
                                              android.R.layout.simple_list_item_1,
                                              getResources().getStringArray(R.array.questions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        enteredAnswer = (EditText) findViewById( R.id.answerField);

        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myIntent;

                myIntent = new Intent( CreateProfile1.this, CreateProfile2.class);
                if ( enteredUsername.getText().length() <= 0 || enteredPassword.getText().length() <= 0 )
                {
                    Toast.makeText( CreateProfile1.this, "Please fill username and password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startActivity(myIntent);
                }
            }
        });
    }
}
