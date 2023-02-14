package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpVerificationActivity extends AppCompatActivity {
    
    Button button_validate;
    EditText edit_text_six_digit_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        
        button_validate = findViewById(R.id.button_validate);
        edit_text_six_digit_otp = findViewById(R.id.edit_text_six_digit_otp);
        
        button_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write code here
                if(isValidInput()){
                    Toast.makeText(OtpVerificationActivity.this, "Validation Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidInput(){
        String otp = edit_text_six_digit_otp.getText().toString();
        if(otp.isEmpty())
            return setError(edit_text_six_digit_otp, "This Field Cannot be Empty");

        if(otp.length()<6)
            return setError(edit_text_six_digit_otp, "Please Enter Valid OTP");

        return true;
    }
    private boolean setError(EditText editText, String error){
        editText.setError(error);
        editText.requestFocus();
        return false;
    }
}