package com.example.user.winit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CreateProfile2 extends AppCompatActivity {

    // Properties
    Button createMyProfile;
    Button allergies;
    Button healthProblems;
    String[] allergyItems;
    String[] healthProblemItems;
    boolean[] allergyCheckedItems;
    boolean[] hpCheckedItems;
    ArrayList<Integer> userSelectedAllergies;
    ArrayList<Integer> userSelectedHProblems;
    UserProfile theProfile;
    UserProfile readingProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile2);

        createMyProfile = (Button) findViewById( R.id.createMyProfile);

        allergies = (Button) findViewById(R.id.allergyList);
        healthProblems = (Button) findViewById(R.id.healthProblemList);

        allergyItems = getResources().getStringArray( R.array.allergies);
        healthProblemItems = getResources().getStringArray( R.array.healthProblems);

         allergyCheckedItems = new boolean[ allergyItems.length];
         hpCheckedItems = new boolean[ healthProblemItems.length];

         userSelectedAllergies = new ArrayList<>();
         userSelectedHProblems = new ArrayList<>();

         allergies.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View view)
             {
                 AlertDialog.Builder allergyBuilder = new AlertDialog.Builder( CreateProfile2.this);
                 allergyBuilder.setTitle( "Currently Supported Allergy List");
                 allergyBuilder.setMultiChoiceItems(allergyItems, allergyCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int position, boolean isChecked)
                     {
                        if ( isChecked )
                        {
                            if ( !userSelectedAllergies.contains( position))
                            {
                                userSelectedAllergies.add( position);
                            }

                            else if ( userSelectedAllergies.contains( position))
                            {
                                userSelectedAllergies.remove( position);
                            }
                        }
                     }
                 });

                 allergyBuilder.setCancelable( false);
                 allergyBuilder.setPositiveButton( "OK", null);
                 allergyBuilder.setNegativeButton( "Dismiss", null);
                 allergyBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int which)
                     {
                         for ( int i = 0; i < allergyCheckedItems.length; i++ )
                         {
                             allergyCheckedItems[ i] = false;
                             userSelectedAllergies.clear();
                         }
                     }
                 });

                 AlertDialog allergyDialog;
                 allergyDialog = allergyBuilder.create();
                 allergyDialog.show();
             }
         });


        healthProblems.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder healthProblemBuilder = new AlertDialog.Builder( CreateProfile2.this);
                healthProblemBuilder.setTitle( "Currently Supported Allergy List");
                healthProblemBuilder.setMultiChoiceItems(healthProblemItems, hpCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked)
                    {
                        if ( isChecked )
                        {
                            if ( !userSelectedHProblems.contains( position))
                            {
                                userSelectedHProblems.add( position);
                            }

                            else if ( userSelectedHProblems.contains( position))
                            {
                                userSelectedHProblems.remove( position);
                            }
                        }
                    }
                });

                healthProblemBuilder.setCancelable( false);
                healthProblemBuilder.setPositiveButton( "OK", null);
                healthProblemBuilder.setNegativeButton( "Dismiss", null);
                healthProblemBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which)
                    {
                        for ( int i = 0; i < allergyCheckedItems.length; i++ )
                        {
                            allergyCheckedItems[ i] = false;
                            userSelectedAllergies.clear();
                        }
                    }
                });

                AlertDialog hProblemDialog;
                hProblemDialog = healthProblemBuilder.create();
                hProblemDialog.show();
            }
        });

        createMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               theProfile = new UserProfile( CreateProfile1.test1, CreateProfile1.test2,
                      CreateProfile1.spinner.getSelectedItem().toString(), CreateProfile1.test3);

                for ( String allergyItem : allergyItems )
                {
                    theProfile.addAllergy( allergyItem);
                }

                for ( String hPItem : healthProblemItems )
                {
                    theProfile.addHealthProblem( hPItem);
                }

                addUserProfile( theProfile);

            }
        });


    }

    public static void addUserProfile( UserProfile theProfile)
    {
        DatabaseReference userProfileRef;
        userProfileRef = CreateProfile1.database.getReference("User Profiles");

        userProfileRef.setValue( theProfile);
    }

    /**
    public static String readUserProfile()
    {

        DatabaseReference read;
        read = CreateProfile1.database.getReference( "User Profiles");

        read.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> keys;
                keys = dataSnapshot.getChildren();

                for ( DataSnapshot key : keys)
                {
                    UserProfile temp;
                    temp = (UserProfile) key.getValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
     */
}
