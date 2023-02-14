package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button buttonSendOtp;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        bindComponents();

       buttonSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isValidInput()){
                    Toast.makeText(ForgotPasswordActivity.this, "OTP Sent to "+" "+editTextEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                    // edit below lines for passing the input email for the new activity
                    Intent i = new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class);
                    startActivity(i);

                }
            }
        });
    }

    private void bindComponents(){
        buttonSendOtp = findViewById(R.id.button_send_otp);
        editTextEmail = findViewById(R.id.edit_text_forgot_password_email);
    }
    private boolean isValidInput(){
        String email = editTextEmail.getText().toString();
        if(email.isEmpty())
            return setError(editTextEmail, "This Field Cannot be Empty");

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return setError(editTextEmail, "Please Enter Valid Email Address");

        return true;
    }

    private boolean setError(EditText editText, String error){
        editText.setError(error);
        editText.requestFocus();
        return false;
    }

}