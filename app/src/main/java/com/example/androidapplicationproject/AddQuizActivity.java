//package com.example.androidapplicationproject;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.NumberPicker;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class AddQuizActivity extends AppCompatActivity {
//    EditText question_input, opt1, opt2, opt3, opt4;
//    NumberPicker answer;
//    Button next_btn, finish_btn;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_addquiz);
//
//        question_input = findViewById(R.id.question_input);
//        opt1 = findViewById(R.id.opt1);
//        opt2 = findViewById(R.id.opt2);
//        opt3 = findViewById(R.id.opt3);
//        opt4 = findViewById(R.id.opt4);
//        answer = findViewById(R.id.answer);
//        next_btn = findViewById(R.id.next_btn);
//        finish_btn = findViewById(R.id.finish_btn);
//
//        Intent intent = getIntent();
//        String titleID = intent.getStringExtra(AddTitleActivity.EXTRA_TITLEID);
//
//        DBHelper db = new DBHelper(AddQuizActivity.this);
//
//        next_btn.setOnClickListener(view -> {
//            String question = question_input.getText().toString().trim();
//            String option1 = opt1.getText().toString().trim();
//            String option2 = opt2.getText().toString().trim();
//            String option3 = opt3.getText().toString().trim();
//            String option4 = opt4.getText().toString().trim();
//            String ans = String.valueOf(answer.getValue());
//
//            if(question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || ans.equals("0")){
//                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                if(db.addQuizFail(titleID, question, option1, option2, option3, option4, ans )){
//                    Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_SHORT).show();
//                    Intent addquiz_intent = new Intent(getApplicationContext(), AddQuizActivity.class);
//                    startActivity(addquiz_intent);
//                }else{
//                    Toast.makeText(getApplicationContext(), "Upload unsuccessful. Please try again.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        finish_btn.setOnClickListener(view -> {
//            Intent gohome_intent = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(gohome_intent);
//        });
//
//
//    }
//
//
//
//}
