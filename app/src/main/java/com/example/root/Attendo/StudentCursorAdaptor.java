package com.example.root.Attendo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.root.Attendo.Data.StudentContract;

/**
 * Created by root on 7/27/17.
 */

public class StudentCursorAdaptor extends CursorAdapter {
    public StudentCursorAdaptor(Context context, Cursor c) {
        super(context, c,0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView rollNumberTextView = (TextView)view.findViewById(R.id.rollnumc);
        TextView nameTextView = (TextView)view.findViewById(R.id.namec);

        int rollColumnIndex = cursor.getColumnIndex(StudentContract.StudentEntry.ROLL_NUMBER);
        int nameColumnIndex = cursor.getColumnIndex(StudentContract.StudentEntry.STUDENT_NAME);

        String roll = cursor.getString(rollColumnIndex);
        String name = cursor.getString(nameColumnIndex);

        rollNumberTextView.setText(roll);
        nameTextView.setText(name);

    }

}
