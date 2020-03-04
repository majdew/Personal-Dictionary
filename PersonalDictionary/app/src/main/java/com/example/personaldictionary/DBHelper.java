package com.example.personaldictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "dictionary";
    public final static int DATABASE_VERSION = 1;
    public final static String TABLE_NAME = "vocabularies";
    public final static String COLUMN_ID = "_id";
    public final static String COLOMN_WORD = "word";
    public final static String COLOMN_MEANING = "meaning";
    public static final String CREATE_TABLE= "CREATE TABLE " +TABLE_NAME
            + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLOMN_WORD + " VARCHAR (50) NOT NULL, "
            + COLOMN_MEANING +  " VARCHAR (50) NOT NULL) ;";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //complete the code here
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //complete the code here
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        this.onCreate(db);

    }
    //insert function here

    //get all vocabularies function here

    //get meaning function here

}
