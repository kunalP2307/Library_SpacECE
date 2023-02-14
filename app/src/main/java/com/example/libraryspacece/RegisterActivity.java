package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextContact, editTextPass, editTextConfirmPass;
    Button buttonSignUp;
    int userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindComponents();
        addListeners();
    }

    private void getUserType(){
        userType = getIntent().getIntExtra("USER_TYPE_EXTRA", 0);
    }

    private void bindComponents(){
        editTextName = findViewById(R.id.edit_text_name_register);
        editTextEmail = findViewById(R.id.edit_text_email_register);
        editTextContact = findViewById(R.id.edit_text_contact_no_register);
        editTextPass = findViewById(R.id.edit_text_password_register);
        editTextConfirmPass = findViewById(R.id.edit_text_confirm_password_register);
        buttonSignUp = findViewById(R.id.button_sign_up);
    }

    private void addListeners(){
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidInput()){

                }
            }
        });
    }

    private boolean isValidInput(){
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String contact = editTextContact.getText().toString();
        String pass = editTextPass.getText().toString();
        String confirmPass = editTextConfirmPass.getText().toString();

        if(name.isEmpty())
            setError(editTextName, "This Field Cannot be Empty");
        if(email.isEmpty())
            setError(editTextEmail, "This Field Cannot be Empty");
        if(contact.isEmpty())
            setError(editTextContact, "This Field Cannot be Empty");
        if(pass.isEmpty())
            setError(editTextPass, "This Field Cannot be Empty");
        if(confirmPass.isEmpty())
            setError(editTextConfirmPass, "This Field Cannot be Empty");

        if(!Pattern.compile("\"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$\"", Pattern.CASE_INSENSITIVE).matcher(name).find())
            setError(editTextName, "Please Enter Valid Name");
        if(!Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).find())
            setError(editTextEmail, "Please Enter Valid Email");
        if(!Pattern.compile("(0/91)?[7-9][0-9]{9}", Pattern.CASE_INSENSITIVE).matcher(contact).find())
            setError(editTextContact, "Please Enter Valid Contact no");
        if(pass.length() < 8)
            setError(editTextPass, "Password must contain atleast 8 characters");
        if(! pass.equals(confirmPass))
            setError(editTextConfirmPass, "Should be same as Password");

        return true;
    }

    private boolean setError(EditText editText, String error){
        editText.setError(error);
        editText.requestFocus();
        return false;
    }

}