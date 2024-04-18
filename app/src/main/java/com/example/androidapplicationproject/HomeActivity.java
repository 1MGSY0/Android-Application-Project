//package com.example.androidapplicationproject;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import android.view.View;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.ArrayList;
//
//public class HomeActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    FloatingActionButton add_btn;
//    ImageView empty_imageview;
//    TextView no_data;
//    DBHelper db;
//    ArrayList<String> title;
//    CustomAdapter customAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        add_btn =  findViewById(R.id.add_btn);
//        empty_imageview = findViewById(R.id.empty_imageview);
//        no_data = findViewById(R.id.no_data);
////        add_btn.setOnClickListener(view -> {
////            Intent intent = new Intent(HomeActivity.this, AddTitleActivity.class);
////            startActivity(intent);
////        });
//
//        db = new DBHelper(HomeActivity.this);
//        title = new ArrayList<>();
//        storeTitle();
//
//        customAdapter = new CustomAdapter(HomeActivity.this, this, title);
//        recyclerView.setAdapter(customAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 1){
//            recreate();
//        }
//    }
//
//    void storeTitle()
//    {
//        Cursor cursor = db.readAllTitle();
//        if(cursor.getCount() == 0){
//            empty_imageview.setVisibility(View.VISIBLE);
//            no_data.setVisibility(View.VISIBLE);
//        }else{
//            while (cursor.moveToNext()){
//                title.add(cursor.getString(0));
//            }
//        }
//    }
//}
