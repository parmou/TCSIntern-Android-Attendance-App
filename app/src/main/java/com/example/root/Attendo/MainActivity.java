package com.example.root.Attendo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String Option[] = { "Attendace" , "Add Record"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.cirmenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.download,R.drawable.download)
                    .addSubMenu(Color.parseColor("#258CFF"),R.drawable.icon_attendance_big)
                    .addSubMenu(Color.parseColor("#258CFF"),R.drawable.add)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(MainActivity.this, Option[index],Toast.LENGTH_SHORT).show();
                        switch (index){
                            case 0:
                                startActivity(new Intent(MainActivity.this,Welcome.class));
                                break;
                            case 1:
                                startActivity(new Intent(MainActivity.this,AddData.class));
                        }

                    }
                });

/*
        Spinner spinner;
        String path[] = {"abc","bcd"};

        ArrayAdapter <String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,path);
        spinner = (Spinner)findViewById(R.id.branch);
        spinner.setAdapter(adaptor);*/
    }

}
