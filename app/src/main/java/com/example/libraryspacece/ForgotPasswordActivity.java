package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                // edit below lines for passing the input email for the new activity
                Intent i = new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class);
                startActivity(i);
            }
        });
    }

    private void bindComponents(){
        buttonSendOtp = findViewById(R.id.button_send_otp);
        editTextEmail = findViewById(R.id.edit_text_forgot_password_email);
    }
}