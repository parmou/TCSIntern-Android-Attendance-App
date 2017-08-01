package com.example.root.Attendo;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String Option[] = { "Attendace" , "Add Record"};
    String passvalues = " ";
    ImageButton Attendance, AddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent tech1 = getIntent();
        passvalues = tech1.getStringExtra("teacherdetails");

        FloatingActionButton f1 = (FloatingActionButton)findViewById(R.id.coptions);
        FloatingActionButton f2 = (FloatingActionButton)findViewById(R.id.markattendance);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attend = new Intent(MainActivity.this, Welcome.class);
                attend.putExtra("teacherdata",passvalues);
                startActivity(attend);

            }
        });
        FloatingActionButton f3 = (FloatingActionButton)findViewById(R.id.adddata);
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddData.class));

            }
        });


        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.cirmenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.download,R.drawable.download)
                    .addSubMenu(Color.parseColor("#258CFF"),R.drawable.icon_attendance_big)
                    .addSubMenu(Color.parseColor("#258CFF"),R.drawable.add)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                       // Toast.makeText(MainActivity.this, Option[index],Toast.LENGTH_SHORT).show();
                        switch (index){
                            case 0:
                                //startActivity(new Intent(MainActivity.this,Welcome.class));
                                Intent attend = new Intent(MainActivity.this, Welcome.class);
                                attend.putExtra("teacherdata",passvalues);
                                startActivity(attend);
                                break;
                            case 1:
                                startActivity(new Intent(MainActivity.this,AddData.class));
                        }

                    }
                });

    }

}
