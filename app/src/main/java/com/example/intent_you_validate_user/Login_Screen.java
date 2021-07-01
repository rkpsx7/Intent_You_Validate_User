package com.example.intent_you_validate_user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Screen extends AppCompatActivity {
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mbtnLogin;

    String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initViews();

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isEmailValid = isEmailValid();
               boolean isPasswordValid = isPasswordValid();
                if(isEmailValid && isPasswordValid){
                    Intent intent = new Intent(Login_Screen.this,Home_Activity.class);
                    intent.putExtra("email",mEtEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private boolean isPasswordValid() {
        if(mEtPassword.getText().toString().trim().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Password Length is less than 6");
            return false;
        }
    }

    private boolean isEmailValid() {
        if(mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }else{
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.EtEmail);
        mEtPassword = findViewById(R.id.EtPassword);
        mbtnLogin = findViewById(R.id.btnLogin);
    }
}