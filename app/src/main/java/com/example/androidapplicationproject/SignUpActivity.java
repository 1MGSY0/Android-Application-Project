package com.example.androidapplicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText username_input, email_input, password_input, password_reenter;
    Button signup_btn, to_signin_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        username_input = findViewById(R.id.username_input);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        password_reenter = findViewById(R.id.password_reenter);
        signup_btn =  findViewById(R.id.signup_btn);
        to_signin_btn =  findViewById(R.id.to_signin_btn);
        DBHelper db = new DBHelper(SignUpActivity.this);

        signup_btn.setOnClickListener(view -> {
            String username = username_input.getText().toString().trim();
            String password = password_input.getText().toString().trim();
            String email = email_input.getText().toString().trim();
            String password_re = password_reenter.getText().toString().trim();

            if(username.isEmpty() || password.isEmpty() || email.isEmpty() || password_re.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
            else{
                if(db.EmailExist(email)){
                    Toast.makeText(getApplicationContext(), "This Email already exists", Toast.LENGTH_SHORT).show();
                }else if(!password.equals(password_re)){
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }else{
                    if(!db.addUserFail(username, email, password)){
                        Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Sign-Up Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        to_signin_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}
