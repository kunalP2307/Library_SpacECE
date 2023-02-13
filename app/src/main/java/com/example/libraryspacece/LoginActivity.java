package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextView textViewSignUp, textViewForgotPassword;
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindComponents();
        addListeners();

    }

    private void bindComponents(){
        textViewForgotPassword = findViewById(R.id.text_view_forgot_pass);
        textViewSignUp = findViewById(R.id.text_view_sign_up);
        editTextEmail = findViewById(R.id.edit_text_login_email);
        editTextPassword = findViewById(R.id.edit_text_login_password);
        buttonLogin = findViewById(R.id.button_login);
    }

    private void addListeners() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // need to add validation function call
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sign up

            }
        });

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // forgot password
            }
        });
    }

    //TODO: Password checking must be debug properly
    private void isValidInput(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(email.isEmpty())
           setError(editTextEmail, "This Field Cannot be Empty");

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
          setError(editTextEmail, "Please Enter Valid Email Address");

        if(password.isEmpty())
            setError(editTextPassword, "This Field Cannot be Empty");

        if(password.length() < 8 || !isValidPassword(password) ){
            setError(editTextPassword,"Password must contain atleast 8 characters with minimum one number and one symbol");}
    }

    private boolean setError(EditText editText, String error){
        editText.setError(error);
        editText.requestFocus();
        return false;
    }



    //TODO: This function must be check once
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }



}