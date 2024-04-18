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

    private static final String TITLE_TABLE = "title";
    private static final String TITLE_ID = "id";
    private static final String QUIZ_TITLE = "quiztitle";
    private static final String INFO = "info";

    private static final String RECORD_TABLE = "record";
    private static final String RECORD_ID = "id";
    private static final String RESULT = "result";

    private static final String HISTORY_TABLE = "history";
    private static final String HISTORY_ID = "id";
    private static final String DURATION = "duration";
    private static final String SCORE = "score";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String title_query =
                "CREATE TABLE " + TITLE_TABLE +
                        " (" + TITLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        QUIZ_TITLE + " TEXT, " +
                        INFO + " TEXT)" ;
        db.execSQL(title_query);

        String record_query =
                "CREATE TABLE " + RECORD_TABLE +
                        " (" + RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        HISTORY_ID + " TEXT, " +
                        QUIZ_ID + " TEXT, " +
                        RESULT + " TEXT)" ;
        db.execSQL(record_query);

        String history_query =
                "CREATE TABLE " + HISTORY_TABLE +
                        " (" + HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TITLE_ID + " TEXT, " +
                        SCORE + " TEXT, " +
                        DURATION + " TEXT)" ;
        db.execSQL(history_query);

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
                        TITLE_ID + " TEXT, " +
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
        db.execSQL("DROP TABLE IF EXISTS " + TITLE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECORD_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + HISTORY_TABLE);
        onCreate(db);
    }

    public Boolean EmailExist(String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        String check_email =
                "SELECT * FROM " + USER_TABLE +
                        " WHERE " + EMAIL + " = ?";

        Cursor cursor = db.rawQuery(check_email, new String[]{email});
        Boolean exist = cursor.getCount() > 0;
        cursor.close();
        return exist;
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
        Boolean exist = cursor.getCount() > 0;
        cursor.close();
        return exist;
    }

//    public Boolean addQuizFail(String id, String question, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//
//        content.put(TITLE_ID, id);
//        content.put(QUESTION, question);
//        content.put(OPTION_1, option1);
//        content.put(OPTION_2, option2);
//        content.put(OPTION_3, option3);
//        content.put(OPTION_4, option4);
//        content.put(ANSWER, answer);
//        long result = db.insert(QUIZ_TABLE, null,content);
//        return result == -1;
//    }

//    public Boolean addTitleFail(String title, String info) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//
//        content.put(QUIZ_TITLE, title);
//        content.put(INFO, info);
//        long result = db.insert(TITLE_TABLE, null,content);
//        return result == -1;
//    }
//
//    Cursor getTitleID(String title) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        String get_titleID =
//                "SELECT " +TITLE_ID+ " FROM " + TITLE_TABLE +
//                        " WHERE " + QUIZ_TITLE + " = ?";
//
//        Cursor cursor = db.rawQuery(get_titleID, new String[]{title});
//        return cursor;
//    }
//
//    Cursor pullQuizFromTitleID(String titleID) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        String pull_quiz =
//                "SELECT * FROM " + QUIZ_TABLE +
//                        " WHERE " + TITLE_ID + " = ?";
//
//        Cursor cursor = null;
//        if(db !=null){
//            cursor = db.rawQuery(pull_quiz, new String[]{titleID});
//        }
//        return cursor;
//    }
//
//    Cursor readAllTitle(){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        String find_alltitle =
//                "SELECT " + QUIZ_TITLE + " FROM " + TITLE_TABLE;
//
//        Cursor cursor = null;
//        if(db !=null){
//            cursor = db.rawQuery(find_alltitle, null);
//        }
//        return cursor;
//    }

//    public Boolean addHistory(String titleID, String score, String duration) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//
//        content.put(TITLE_ID, titleID);
//        content.put(SCORE, score);
//        content.put(DURATION, duration);
//        long result = db.insert(HISTORY_TABLE, null,content);
//        return result == -1;
//    }
//
//    public Boolean answer(String username, String email, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//
//        content.put(USERNAME, username);
//        content.put(EMAIL, email);
//        content.put(PASSWORD, password);
//        long result = db.insert(USER_TABLE, null,content);
//        return result == -1;
//    }

}
