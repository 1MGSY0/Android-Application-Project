package com.example.androidapplicationproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private Button opt1_btn, opt2_btn, opt3_btn, opt4_btn;
    private TextView txtTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        txtTimer = findViewById(R.id.txtTimer);
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisRemaining) {
                txtTimer.setText("Seconds remaining: " + millisRemaining / 1000);
            }
            public void onFinish() {
                txtTimer.setText("Time Up!");
            }
        }.start();

        opt1_btn = findViewById(R.id.opt1_btn);
        opt2_btn = findViewById(R.id.opt2_btn);
        opt3_btn = findViewById(R.id.opt3_btn);
        opt4_btn = findViewById(R.id.opt4_btn);
//        opt1_btn.setOnClickListener(view -> {
//            new HttpTask().execute("http://10.0.2.2:9999/craftflow/home");  // Tomcat at localhost:9999
//            Toast.makeText(this, "Answered!", Toast.LENGTH_LONG).show(); // Toast a message
//        });


    }
//    private class HttpTask extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... strURLs) {
//            URL url = null;
//            HttpURLConnection conn = null;
//            try {
//                url = new URL(strURLs[0]);
//                conn = (HttpURLConnection) url.openConnection();
//                // Get the HTTP response code (e.g., 200 for "OK", 404 for "Not found")
//                // and pass a string description in result to onPostExecute(String result)
//                int responseCode = conn.getResponseCode();
//                if (responseCode == HttpURLConnection.HTTP_OK) {  // 200
//                    return "OK (" + responseCode + ")";
//                } else {
//                    return "Fail (" + responseCode + ")";
//                }
//            } catch (IOException e) {
//                return "Unable to retrieve web page. URL may be invalid.";
//            }
//        }
//
//        // Displays the result of the AsyncTask.
//        // The String result is passed from doInBackground().
////        @Override
////        protected void onPostExecute(String result) {
////            txtResponse.setText(result);  // put it on TextView
////        }
//    }
}

