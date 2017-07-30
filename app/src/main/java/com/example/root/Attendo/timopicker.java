package com.example.root.Attendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.root.Attendo.R;

import java.util.Calendar;

public class timopicker extends AppCompatActivity {
    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private String format = "";
    String timevalues = " ";
    String passvalues = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timopicker);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
       // time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();

        Intent datevalues = getIntent();
        passvalues = datevalues.getStringExtra("datevalues");

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);
    }

    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        showTime(hour, min);
        Intent attendance = new Intent(timopicker.this,Attendance.class);
        attendance.putExtra("passvalues3",timevalues);
        startActivity(attendance);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

       // time.setText(new StringBuilder().append(hour).append(" : ").append(min)
             //   .append(" ").append(format));

        timevalues = passvalues + " " + hour+ ":"+ min + " " + format;
       // Toast.makeText(timopicker.this,timevalues,Toast.LENGTH_SHORT).show();
    }


}

