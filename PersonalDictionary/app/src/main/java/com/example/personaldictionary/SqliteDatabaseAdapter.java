package com.example.personaldictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SqliteDatabaseAdapter  {
    SQLiteDatabase sqLiteDatabase ;
    DBHelper sqliteHelper ;
    String [] tableColumns = {DBHelper.COLUMN_ID , DBHelper.COLOMN_WORD ,
            DBHelper.COLOMN_MEANING };

    public SqliteDatabaseAdapter(Context context) {
        this.sqliteHelper = new DBHelper(context) ;
    }

    public void open(){
        this.sqLiteDatabase = sqliteHelper.getWritableDatabase();
    }

    public  void close(){
        this.sqLiteDatabase.close();
    }

    public boolean insertWord(Dictionary d){
        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.COLOMN_WORD, d.getWord());
        contentValues.put(DBHelper.COLOMN_MEANING , d.getMean());

        long  rowId = this.sqLiteDatabase.insert(DBHelper.TABLE_NAME , null , contentValues);
        this.close();
        return (rowId!=0);
    }

    public ArrayList<Dictionary> getDictionary(){
        ArrayList<Dictionary> dictionaryArrayList = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int  id = cursor.getInt(0);
            String  word= cursor.getString(1);
            String  meaning = cursor.getString(2);
            Dictionary d = new Dictionary(id,word ,meaning);
            dictionaryArrayList.add(d);
            cursor.moveToNext();
        }
        cursor.close();
        this.close();
        return dictionaryArrayList;
    }








}
