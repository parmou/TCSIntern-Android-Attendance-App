package com.example.root.Attendo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.Attendo.Data.StudentContract;
import com.example.root.Attendo.Data.StudentDbHelper;
import com.example.root.Attendo.StudentCursorAdaptor;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {

    ListView displayall ;
    String passvlues4;
    ArrayList<String> PresentOnes = new ArrayList<String>();
    CheckBox ch;

    //CheckedTextView ch = (CheckedTextView)findViewById(R.id.checkboxxx);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        displayall = (ListView)findViewById(R.id.studentdisplay);
     //   ch = ((CheckBox)findViewById(R.id.checkb));
       // ch.setClickable(false);





        displayDatabaseInfo();
        displayall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox ch = (CheckBox)view.findViewById(R.id.checkb);
                ch.setChecked(!ch.isChecked());


                Cursor cursor1 = (Cursor)displayall.getItemAtPosition(i);
                String studentName = cursor1.getString(cursor1.getColumnIndexOrThrow(StudentContract.StudentEntry.STUDENT_NAME));
                String studentRoll = cursor1.getString(cursor1.getColumnIndexOrThrow(StudentContract.StudentEntry.ROLL_NUMBER));
                String studentName1 = studentName + " (" + studentRoll + ") ";
               // Toast.makeText(getApplicationContext(),abc + "is Present",Toast.LENGTH_SHORT).show();
                PresentOnes.add(studentName1);

            }
        });
    }

    private void displayDatabaseInfo() {

        StudentDbHelper mdb = new StudentDbHelper(this);
        SQLiteDatabase db = mdb.getWritableDatabase();

        String[] projection = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.ROLL_NUMBER,
                StudentContract.StudentEntry.STUDENT_NAME
        };
        final Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME,projection, null, null,null,null,null);

        StudentCursorAdaptor adaptor = new StudentCursorAdaptor(this,cursor);
        displayall.setAdapter(adaptor);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.saveattendance, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done:

                Intent datetime = getIntent();
                String passvalues4 = datetime.getStringExtra("passvalues3");
                //Toast.makeText(Attendance.this,passvalues4,Toast.LENGTH_SHORT).show();

                Intent export = new Intent(Attendance.this, Export.class);
                export.putStringArrayListExtra("PresentOnes",PresentOnes);
                export.putExtra("finalvalues", passvalues4);
                startActivity(export);
                return (true);
        }
        return(super.onOptionsItemSelected(item));
    }

}




