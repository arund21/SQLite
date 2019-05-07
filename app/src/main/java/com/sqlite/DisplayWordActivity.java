package com.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.Word;


public class DisplayWordActivity extends AppCompatActivity{
private ListView lstWord;
private EditText etSearch;
private Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);
        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);


        lstWord = findViewById(R.id.lstWords);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadWord();
            }
        });


    }
    private void LoadWord(){

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Word> wordList = new ArrayList<>();
        List<Word> searchwordList = new ArrayList<>();
//        wordList = myHelper.GetAllWords(sqLiteDatabase);
        searchwordList = myHelper.getWordByName(etSearch.getText().toString(),sqLiteDatabase);

        final HashMap<String, String> hashMap = new HashMap<>();

        for (int i =0; i<searchwordList.size(); i++){
            hashMap.put(searchwordList.get(i).getWord(),searchwordList.get(i).getMeaning());
        }

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        lstWord.setAdapter(stringArrayAdapter);

lstWord.setOnClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String key = parent.getItemAtPosition(position).toString();
        Intent intent = new Intent(DisplayWordActivity.this,WordDetailsActivity.class);
        intent.putExtra("word",parent.getItemAtPosition(position).toString());
        intent.putExtra("meaning",meaning);
        startActivity(intent);
    }
});
    }


}
