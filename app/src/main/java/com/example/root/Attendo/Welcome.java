package com.example.root.Attendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Welcome extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button b1;
    Spinner spinner,spinner1,spinner2;
    String path[] = {"abc","bcd"};
    String abc[] = {"Sub1","Sub2"};
    String bcd[] = {"Sub3","Sub4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,path);
        spinner = (Spinner)findViewById(R.id.branch);
        spinner.setAdapter(adaptor);
        spinner.setOnItemSelectedListener(this);

        b1 = (Button)findViewById(R.id.next);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datetime = new Intent(Welcome.this,DateTImePicker.class);
                startActivity(datetime);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = spinner.getSelectedItemPosition();
        switch (position)
        {
            case 0:
                ArrayAdapter<String> adaptor1 = new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,abc);
                spinner1 = (Spinner)findViewById(R.id.subject);
                spinner1.setAdapter(adaptor1);
                break;
            case 1:
                ArrayAdapter<String> adaptor2= new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,bcd);
                spinner1 = (Spinner)findViewById(R.id.subject);
                spinner1.setAdapter(adaptor2);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
