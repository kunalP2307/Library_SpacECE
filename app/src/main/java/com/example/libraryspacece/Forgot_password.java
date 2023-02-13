package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgot_password extends AppCompatActivity {

    Button sendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sendOtp = findViewById(R.id.button_send_otp);

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edit below lines for passing the input email for the new activity
                Intent i = new Intent(Forgot_password.this, OtpVerification.class);
                startActivity(i);
            }
        });
    }
}