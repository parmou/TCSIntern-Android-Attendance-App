package com.example.root.Attendo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_db);
        SQLiteDatabase db = openOrCreateDatabase("StudentData", MODE_APPEND, null);
        Cursor cr = db.rawQuery("select * from Sample_01",null);
        while(cr.moveToNext()){
            String rl = cr.getString(0);
            String nm = cr.getString(1);
            String sn = cr.getString(2);
            String details = "rl\t + nm\t+ sn";
        }
    }
}
