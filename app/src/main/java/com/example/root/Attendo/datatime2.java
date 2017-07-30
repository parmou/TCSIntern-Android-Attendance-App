package com.example.root.Attendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.root.Attendo.*;

public class datatime2 extends AppCompatActivity {

    String datetimevalues;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatime2);
        Intent getsubject = getIntent();
        subject = getsubject.getStringExtra("passvalues");


         final DatePicker dp = (DatePicker)findViewById(R.id.datePicker);

        Button bd = (Button)findViewById(R.id.setdate);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(datatime2.this,dp.getDayOfMonth()+" "+dp.getMonth()+" "+dp.getYear(), Toast.LENGTH_SHORT).show();
                String day = String.valueOf(dp.getDayOfMonth());
                String month = String.valueOf(dp.getMonth());
                String year = String.valueOf(dp.getYear());
                datetimevalues = subject+" - " +day+ "/"+ month+"/"+year;

                Intent totime = new Intent(datatime2.this,timopicker.class);
                totime.putExtra("datevalues",datetimevalues);
                startActivity(totime);
            }
        });
    }
}
