//package com.example.androidapplicationproject;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.NumberPicker;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class AddTitleActivity extends AppCompatActivity {
//
//    EditText title_input, info_input;
//    Button to_addquiz_btn;
//    DBHelper db;
//    ArrayList<String> titleID;
//
//    public final static String EXTRA_TITLEID = "com.example.testintent.TITLEID";
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_addtitle);
//
//        title_input = findViewById(R.id.title_input);
//        info_input = findViewById(R.id.info_input);
//        to_addquiz_btn = findViewById(R.id.to_addquiz_btn);
//        db = new DBHelper(AddTitleActivity.this);
//        titleID = new ArrayList<>();
//
//        to_addquiz_btn.setOnClickListener(view -> {
//            String title = title_input.getText().toString().trim();
//            String info = info_input.getText().toString().trim();
//
//            if (title.isEmpty() || info.isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            } else {
//                if (!db.addTitleFail(title, info)) {
//                    Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(AddTitleActivity.this, AddQuizActivity.class);
//                    storeTitleID(title);
//                    intent.putExtra(EXTRA_TITLEID, titleID.get(0));
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Upload unsuccessful. Please try again.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    void storeTitleID(String title)
//    {
//        Cursor cursor = db.getTitleID(title);
//        if(cursor.getCount() == 0){
//            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
//        }else{
//            while (cursor.moveToNext()){
//                titleID.add(cursor.getString(0));
//            }
//        }
//    }
//}
