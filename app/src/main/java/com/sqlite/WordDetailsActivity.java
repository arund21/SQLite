package com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WordDetailsActivity extends AppCompatActivity {
    private TextView tvWord,tvMeaning;
    private Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);
        tvWord = findViewById(R.id.tvWord);
        tvMeaning = findViewById(R.id.tvMeaning);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
           Integer wid = bundle.getInt("wid");
           String wordExtra = bundle.getString("word");
           String meaningExtra = bundle.getString("meaning");
            tvMeaning.setText(meaningExtra);
            tvWord.setText(wordExtra +" id: "+wid);
        }
    }
}
