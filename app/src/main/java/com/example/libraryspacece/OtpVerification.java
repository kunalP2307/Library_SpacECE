package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OtpVerification extends AppCompatActivity {
    
    Button button_validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        
        button_validate = findViewById(R.id.button_validate);
        
        
        button_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write code here
                Toast.makeText(OtpVerification.this, "Validation Completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}