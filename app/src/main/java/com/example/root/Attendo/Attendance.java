package com.example.root.Attendo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.root.Attendo.Data.StudentContract;
import com.example.root.Attendo.Data.StudentDbHelper;
import com.example.root.Attendo.StudentCursorAdaptor;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {

    /*ArrayList <String> checkedOnes = new ArrayList<>();
    ArrayList <String> notCheckedOnes = new ArrayList<>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        displayDatabaseInfo();

    }

    private void displayDatabaseInfo() {
        ListView displayall = (ListView)findViewById(R.id.studentdisplay);
        StudentDbHelper mdb = new StudentDbHelper(this);
        SQLiteDatabase db = mdb.getWritableDatabase();

        String[] projection = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.ROLL_NUMBER,
                StudentContract.StudentEntry.STUDENT_NAME
        };
        Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME,projection, null, null,null,null,null);

        StudentCursorAdaptor adaptor = new StudentCursorAdaptor(this,cursor);
        displayall.setAdapter(adaptor);

    }

}




