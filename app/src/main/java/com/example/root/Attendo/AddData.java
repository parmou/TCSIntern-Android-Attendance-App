package com.example.root.Attendo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.Attendo.Data.StudentContract;
import com.example.root.Attendo.Data.StudentDbHelper;


public class AddData extends AppCompatActivity {

    private EditText mRollNumberEditText;
    private EditText mNameEditText;
    private EditText mBranchEditText;
    private EditText mSemEditText;
    private Button mAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        mRollNumberEditText = (EditText)findViewById(R.id.lrollnumber);
        mNameEditText = (EditText)findViewById(R.id.lname);
        mBranchEditText= (EditText)findViewById(R.id.lbranch);
        mSemEditText = (EditText)findViewById(R.id.lsem);

        mAdd = (Button) findViewById(R.id.addintodb);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });

    }
    public void InsertData(){

        String DRollNumber = mRollNumberEditText.getText().toString().trim();
        String DName = mNameEditText.getText().toString().trim();
        String DBranch = mBranchEditText.getText().toString().trim();
        String DSem = mSemEditText.getText().toString().trim();
        int DSemester = Integer.parseInt(DSem);

        StudentDbHelper idbhelper = new StudentDbHelper(this);
        SQLiteDatabase db = idbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StudentContract.StudentEntry.ROLL_NUMBER, DRollNumber);
        values.put(StudentContract.StudentEntry.STUDENT_NAME, DName);
        values.put(StudentContract.StudentEntry.STUDENT_BRANCH, DBranch);
        values.put(StudentContract.StudentEntry.STUDENT_SEMESTER, DSemester);
        values.put(StudentContract.StudentEntry.STUDENT_ATTENDANCE, "A");

        long resultinsert = db.insert(StudentContract.StudentEntry.TABLE_NAME, null, values);

        if(resultinsert == -1)
            Toast.makeText(AddData.this," Error",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AddData.this,"New Record Added Successfully",Toast.LENGTH_SHORT).show();

    }
}
