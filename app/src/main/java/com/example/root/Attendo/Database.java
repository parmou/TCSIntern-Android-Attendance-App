package com.example.root.Attendo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    EditText RollNumber, Name, Surname;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        SQLiteDatabase db = openOrCreateDatabase("StudentData", MODE_APPEND, null);
        db.execSQL("create table if not exists Sample_01(RollNumber INTEGER PRIMARY KEY, Name VARCHAR, Surname VARCHAR)");
        db.close();
        Toast.makeText(Database.this,"Table",Toast.LENGTH_SHORT).show();

        add = (Button)findViewById(R.id.addintodb);
    }

    public void addindb(View view){
        RollNumber = (EditText)findViewById(R.id.rollnumber);
        Name = (EditText)findViewById(R.id.name);
        Surname = (EditText)findViewById(R.id.surname);

        String Rollnum = RollNumber.getText().toString();
        String name = Name.getText().toString();
        String sname= Surname.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase("StudentData", MODE_APPEND, null);
        String q = "Insert into Sample_01(RollNumber, Name, Surname) values ('" + Rollnum +"', '" + name +"' , '" + sname +"')";
        db.execSQL(q);
        db.close();
        Toast.makeText(this,"Record Inserted", Toast.LENGTH_SHORT).show();
    }


}
