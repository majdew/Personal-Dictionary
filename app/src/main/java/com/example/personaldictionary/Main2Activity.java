package com.example.personaldictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView vocabulariesList;
    DictionaryObjectAdapter dictionaryObjectAdapter;
    SqliteDatabaseAdapter sqliteDatabaseAdapter;
    ArrayList <Dictionary> dictionaryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vocabulariesList = findViewById(R.id.vocabularies_list);
        sqliteDatabaseAdapter = new SqliteDatabaseAdapter(this);
        onResume();


    }

    @Override
    protected void onResume() {
        super.onResume();
        dictionaryArrayList = sqliteDatabaseAdapter.getDictionary();
        dictionaryObjectAdapter = new DictionaryObjectAdapter(this ,dictionaryArrayList );
        vocabulariesList.setAdapter(dictionaryObjectAdapter);
        dictionaryObjectAdapter.notifyDataSetChanged();

    }
}
