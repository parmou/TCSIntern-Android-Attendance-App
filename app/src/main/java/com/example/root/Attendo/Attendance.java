package com.example.root.myapplication;

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

import java.util.ArrayList;

public class Attendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ArrayList <String> checkedOnes = new ArrayList<>();
    ArrayList <String> notCheckedOnes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ListView studentlist = (ListView) findViewById(R.id.studentname);
        SQLiteDatabase db = openOrCreateDatabase("StudentData", MODE_APPEND, null);
        Cursor cursor = db.rawQuery("select * from Sample_01", null);
        CursorAdapter myCursorAdapter = new MyCursorAdapter(this, cursor, 0);
        studentlist.setAdapter(myCursorAdapter);
     //   studentlist.setOnItemClickListener(this);

       /* student.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String students[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.checkbox , students);
        student.setAdapter(adapter);

        student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = ((TextView)view).getText().toString();
                if (checkedOnes.contains(selected)) {
                    checkedOnes.remove(selected);
                } else
                    checkedOnes.add(selected);
            }
        });
    }
        public void ShowPresent(View view){
            String Present =" ";
            for (String presenttemp:checkedOnes) {
                Present +=  presenttemp + "\n";
            }
                Toast.makeText(this,"present\n"+Present,Toast.LENGTH_LONG).show();
*/
        }

    class MyCursorAdapter extends CursorAdapter {

        public MyCursorAdapter(Context context, Cursor cursor, int flags) {
            super(context,cursor,flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            LayoutInflater inflator = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View v  = inflator.inflate(R.layout.row_layout,viewGroup,false);
            return  v;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView Rollname =(TextView)view.findViewById(R.id.rollnumc);
            TextView name =(TextView)view.findViewById(R.id.namec);
            String rollnum = cursor.getString(cursor.getColumnIndex("RollNumber"));
            String na1 = cursor.getString(cursor.getColumnIndex("Name"));
            Rollname.setText(rollnum);
            name.setText(na1);


        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
    /*    public void ShowAbsent(View view){
            String Absent = " ";
            for (String absent:(notCheckedOnes)){
                Absent += absent + "\n";
            }
                Toast.makeText(this,"Absent\n" + Absent, Toast.LENGTH_LONG).show();
        }*/





