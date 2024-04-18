package com.example.androidapplicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private TextView title_start;
    private Button start_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        title_start = findViewById(R.id.title_start);
        start_btn = findViewById(R.id.start_btn);
        start_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
            startActivity(intent);
        });

    }
}
