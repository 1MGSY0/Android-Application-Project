package com.example.androidapplicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    EditText username_input, password_input;
    Button signin_btn, to_signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);
        signin_btn =  findViewById(R.id.signin_btn);
        to_signup_btn =  findViewById(R.id.to_signup_btn);
        DBHelper db = new DBHelper(LoginActivity.this);

        signin_btn.setOnClickListener(view -> {
            String username = username_input.getText().toString().trim();
            String password = password_input.getText().toString().trim();

            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }else{
                if(db.signInCheck(username, password)){
                    Toast.makeText(getApplicationContext(), "Sign-In Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Sign-In Unsuccessful, Please check your account details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        to_signup_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        });

    }
}