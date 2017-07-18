package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner;
        String path[] = {"abc","bcd"};

        ArrayAdapter <String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,path);
        spinner = (Spinner)findViewById(R.id.branch);
        spinner.setAdapter(adaptor);
    }
}
