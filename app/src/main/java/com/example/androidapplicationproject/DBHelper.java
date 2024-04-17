package com.example.androidapplicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "CodetriviaApp.db";
    private static final int DB_VERSION = 1;
    private static final String USER_TABLE = "users";
    private static final String USER_ID = "id";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    private static final String QUIZ_TABLE = "quizes";
    private static final String QUIZ_ID = "id";
    private static final String QUESTION = "question";
    private static final String OPTION_1 = "option1";
    private static final String OPTION_2 = "option2";
    private static final String OPTION_3 = "option3";
    private static final String OPTION_4 = "option4";
    private static final String ANSWER = "answer";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_query =
                "CREATE TABLE " + USER_TABLE +
                        " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        USERNAME + " TEXT, " +
                        EMAIL + " TEXT, " +
                        PASSWORD + " TEXT)" ;
        db.execSQL(user_query);
        String quiz_query =
                "CREATE TABLE " + QUIZ_TABLE +
                        " (" + QUIZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        QUESTION + " TEXT, " +
                        OPTION_1 + " TEXT, " +
                        OPTION_2 + " TEXT, " +
                        OPTION_3 + " TEXT, " +
                        OPTION_4 + " TEXT, " +
                        ANSWER + " TEXT)" ;
        db.execSQL(quiz_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QUIZ_TABLE);
        onCreate(db);
    }

    public Boolean EmailExist(String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        String check_user =
                "SELECT * FROM " + USER_TABLE +
                        " WHERE " + EMAIL + " = ?";

        Cursor cursor = db.rawQuery(check_user, new String[]{email});
        return cursor.getCount() > 0;
    }

    public Boolean addUserFail(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(USERNAME, username);
        content.put(EMAIL, email);
        content.put(PASSWORD, password);
        long result = db.insert(USER_TABLE, null,content);
        return result == -1;
    }

    public Boolean signInCheck(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        String check_user =
                "SELECT * FROM " + USER_TABLE +
                        " WHERE " + USERNAME +
                        " = ? and " + PASSWORD + " = ?";

        Cursor cursor = db.rawQuery(check_user, new String[]{username, password});
        return cursor.getCount() > 0;
    }

}
