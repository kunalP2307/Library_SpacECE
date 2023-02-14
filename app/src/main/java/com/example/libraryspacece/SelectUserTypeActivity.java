package com.example.libraryspacece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectUserTypeActivity extends AppCompatActivity {

    Button buttonDelAgent, buttonUser;
    String USER_TYPE_EXTRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user_type);
        bindComponents();
        addListeners();
    }

    private void bindComponents(){
        buttonUser = findViewById(R.id.button_user_user_type);
        buttonDelAgent = findViewById(R.id.button_del_agent_user_type);
    }

    private void addListeners(){

        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                USER_TYPE_EXTRA = "NORMAL";
                intent.putExtra("USER_TYPE_EXTRA", "user");
                startActivity(intent);
            }
        });

        buttonDelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                USER_TYPE_EXTRA = "DEL_AGENT";
                intent.putExtra("USER_TYPE_EXTRA", "del_agent");
                startActivity(intent);
            }
        });
    }
}