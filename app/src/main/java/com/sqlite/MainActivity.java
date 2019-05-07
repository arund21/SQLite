package com.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    EditText etWord, etMeaning;
    Button btnAdWord,btnShowWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord =findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAdWord = findViewById(R.id.btnAddWord);
        btnShowWords = findViewById(R.id.btnShowWords);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

    btnAdWord.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long id = myHelper.InsertData(etWord.getText().toString(),etMeaning.getText().toString(), sqLiteDatabase);
            if (id > 0){
                Toast.makeText(MainActivity.this,"Successfull: " +id, Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(MainActivity.this,"Error please check",Toast.LENGTH_LONG).show();
            }
        }

    });

btnShowWords.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DisplayWordActivity.class);
        startActivity(intent);
    }
});


    }

}
