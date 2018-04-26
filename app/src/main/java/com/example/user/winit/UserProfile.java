package com.example.user.winit;

import java.util.ArrayList;

/**
 * Created by USER on 26.04.2018.
 */

public class UserProfile
{
    // Properties
    private String username;
    private String password;
    private String secretQuestion;
    private String secretAnswer;
    private String[] allergies;
    private String[] healthProblems;
    private int allergyValid;
    private int hPValid;

    // Constructor
    public UserProfile( String username, String password, String secretQuestion, String secretAnswer)
    {
        this.username = username;
        this.password = password;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
        allergies = new String[ 5];
        healthProblems = new String[ 5];
        allergyValid = 0;
        hPValid = 0;
    }

    // Methods

    public String getSecretAnswer()
    {
        return secretAnswer;
    }

    public String getSecretQuestion()
    {
        return secretQuestion;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUsername( String us)
    {
        username = us;
    }

    public void setPassword( String pw)
    {
        password = pw;
    }

    public void setSecretQuestion( String question)
    {
        secretQuestion = question;
    }

    public void setSecretAnswer( String answer)
    {
        secretAnswer = answer;
    }

    public void addAllergy( String allergy)
    {
        allergies[ allergyValid] = allergy;
        allergyValid++;
    }

    public void addHealthProblem( String healthProblem)
    {
        healthProblems[ hPValid] = healthProblem;
        hPValid++;
    }

    public boolean checkSecretQuestionAnswer( String answer)
    {
        if ( answer.equals( secretAnswer) )
        {
            return true;
        }
        return false;
    }

}
