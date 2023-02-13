package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                if(isValidInput()){
                    // login code
                }
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

    private boolean isValidInput(){
        String email = editTextEmail.getText().toString();
        String password = editTextEmail.getText().toString();

        if(email.isEmpty())
           setError(editTextEmail, "This Field Cannot be Empty");

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
          setError(editTextEmail, "Please Enter Valid Email Address");

        if(password.isEmpty())
            setError(editTextPassword, "This Field Cannot be Empty");

        if(password.length() < 8)
            setError(editTextPassword,"Password must contain atleast 8 characters");

        return true;
    }

    private boolean setError(EditText editText, String error){
        editText.setError(error);
        editText.requestFocus();
        return false;
    }
}