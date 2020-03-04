package com.example.personaldictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText word;
    TextView meaning;
    Button means,addMean,showAllVocabularies;
    SqliteDatabaseAdapter sqliteDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = findViewById(R.id.word);
        meaning = findViewById(R.id.meaning);
        means = findViewById(R.id.means);
        addMean = findViewById(R.id.add_mean);
        sqliteDatabaseAdapter = new SqliteDatabaseAdapter(this);
        showAllVocabularies = findViewById(R.id.show_all);

        means.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList <Dictionary> myDictionary;
                myDictionary = sqliteDatabaseAdapter.getDictionary();
                String insertedWord = word.getText().toString();
                boolean found =false;
                for (int i=0; i<myDictionary.size() ; i++){
                    if(insertedWord.equals(myDictionary.get(i).getWord())){
                        found = true ;
                        meaning.setText(myDictionary.get(i).getMean());
                    }
                }
                if(!found)
                    meaning.setText("Not found");

            }
        });

        addMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogAddMeaning();
            }
        });

        showAllVocabularies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void alertDialogAddMeaning(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        final EditText input = new EditText(MainActivity.this);
        final  String inputWord = word.getText().toString();
        input.setHint("Enter the meaning:");
        alertDialogBuilder.setTitle(inputWord + " means :");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setView(input);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Add",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        String meaningText = input.getText().toString();
                        Dictionary d =new Dictionary(inputWord , meaningText);
                        boolean isInserted = sqliteDatabaseAdapter.insertWord(d);
                        if(isInserted)
                            Toast.makeText(MainActivity.this, "vocbulary added sucessfully", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "There is problem", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
