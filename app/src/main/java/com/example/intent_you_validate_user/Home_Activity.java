package com.example.intent_you_validate_user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {

    private TextView mTvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvEmail = findViewById(R.id.TvEmail);

        Intent intent = getIntent();
        String txt = intent.getStringExtra("email");
        mTvEmail.setText(txt);
    }
}