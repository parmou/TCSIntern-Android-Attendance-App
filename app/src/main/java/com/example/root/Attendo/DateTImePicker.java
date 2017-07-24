package com.example.root.Attendo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class DateTImePicker extends AppCompatActivity implements View.OnClickListener {

    private int hour, min, sec, day, month, year;
    Button bdate, btime,next2;
    EditText edate, etime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        bdate = (Button) findViewById(R.id.datebutton);
        btime = (Button) findViewById(R.id.timebutton);
        next2 = (Button) findViewById(R.id.next2);
        edate = (EditText) findViewById(R.id.sdate);
        etime = (EditText) findViewById(R.id.stime);


        bdate.setOnClickListener(this);
        btime.setOnClickListener(this);
        next2.setOnClickListener(this);



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view == bdate) {
            Calendar c = Calendar.getInstance();
            day = c.get(Calendar.DAY_OF_MONTH);
            month = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    edate.setText((i2) + "/" + (i1 + 1) + "/" + (i));
                }
            }, day, month, year);
            datePickerDialog.show();
                }
            if (view == btime) {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                min = c.get(Calendar.MINUTE);
                sec = c.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        etime.setText((i)+":" + (i1));

                    }
                },hour,min,false);
                timePickerDialog.show();

            }
            if(view == next2){
                Intent in = new Intent(DateTImePicker.this,Attendance.class);
                startActivity(in);
            }


    }


}
