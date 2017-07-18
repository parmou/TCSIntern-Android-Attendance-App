package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {

    ArrayList <String> checkedOnes = new ArrayList<>();
    ArrayList <String> notCheckedOnes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ListView student = (ListView) findViewById(R.id.studentname);
        student.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String students[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.checkbox , students);
        student.setAdapter(adapter);

        student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = ((TextView)view).getText().toString();
                if (checkedOnes.contains(selected)) {
                    notCheckedOnes.add(selected);
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

        }
        public void ShowAbsent(View view){
            String Absent = " ";
            for (String absent:(notCheckedOnes)){
                Absent += absent + "\n";
            }
                Toast.makeText(this,"Absent\n" + Absent, Toast.LENGTH_LONG).show();
        }

}



