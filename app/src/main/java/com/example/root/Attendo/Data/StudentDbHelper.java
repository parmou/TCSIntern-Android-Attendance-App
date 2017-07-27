package com.example.root.Attendo.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 7/27/17.
 */

public class StudentDbHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "student.db";
    private static final int VERSION = 2;

   public StudentDbHelper(Context context) {
       super(context,DATABASE_NAME,null,VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " create table " +  StudentContract.StudentEntry.TABLE_NAME + "("
                + StudentContract.StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + StudentContract.StudentEntry.ROLL_NUMBER + " TEXT NOT NULL,"
                + StudentContract.StudentEntry.STUDENT_NAME + " TEXT NOT NULL,"
                + StudentContract.StudentEntry.STUDENT_BRANCH + " TEXT NOT NULL,"
                + StudentContract.StudentEntry.STUDENT_SEMESTER + " INTEGER NOT NULL,"
                + StudentContract.StudentEntry.STUDENT_ATTENDANCE + " TEXT NOT NULL DEFAULT P);";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
