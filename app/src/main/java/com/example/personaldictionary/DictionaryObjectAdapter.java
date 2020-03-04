package com.example.personaldictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DictionaryObjectAdapter extends ArrayAdapter<Dictionary> {
    public DictionaryObjectAdapter(@NonNull Context context, @NonNull List<Dictionary> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customitem,null);

        Dictionary dictionary = getItem(position);
        TextView vocabularyWord = convertView.findViewById(R.id.cusomListItemWord);
        TextView vocabularyMeaning = convertView.findViewById(R.id.cusomListItemMeaning);


        vocabularyWord.setText( dictionary.getWord() + ": " );
        vocabularyMeaning.setText(dictionary.getMean());

        return convertView;
    }
}
