package com.example.root.Attendo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.Attendo.R;
import com.example.root.Attendo.*;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Export extends AppCompatActivity {

    private static final String LOG_TAG = " ";
    ArrayList<String> PresentOnes = new ArrayList<String>();
    String finalvalues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);

        Intent i = getIntent();
        PresentOnes = i.getStringArrayListExtra("PresentOnes");
        finalvalues = i.getStringExtra("finalvalues");


        StringBuilder sb = new StringBuilder();
        for (String s : PresentOnes) {
            sb.append(s);
            sb.append(" - Present");
            sb.append("\n");
        }

        final String finalize = sb.toString();

        Button Send = (Button)findViewById(R.id.sendmail);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Send email", "");
                String[] TO = {""};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Attendance for " +  finalvalues);
                emailIntent.putExtra(Intent.EXTRA_TEXT, finalize);
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                  //  Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Export.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}

       /* //String loc = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();

        File loc = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(loc, "Attendace.txt");

        FileWriter fl = null;
        try {
            fl = new FileWriter(file);
            try {
                fl.append(finalize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView x = (TextView)findViewById(R.id.testfd);
        x.setText("done");
        */
