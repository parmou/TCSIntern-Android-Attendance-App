package com.example.root.Attendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button b1;
    //TextView test ;
    Spinner spinner,spinner1;
    String path[] = {"CSE","ECE"};
    String CSE[] = {"CSESub1","CSESub2"};
    String ECE[] = {"ECESub1","ECESub2"};
    String passvalues = " ", Branch, Sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent welcometech = getIntent();
        String tname = welcometech.getStringExtra("teacherdata");

        TextView teachername = (TextView)findViewById(R.id.welcometeachername);
        teachername.setText(tname);

        spinner = (Spinner)findViewById(R.id.branch);
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,path);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptor);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = spinner.getSelectedItemPosition();
         Branch = path[position];
        //Toast.makeText(getApplicationContext(),Branch,Toast.LENGTH_SHORT).show();
        switch (position)
        {
            case 0:
                ArrayAdapter<String> adaptor1 = new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,CSE);
                spinner1 = (Spinner)findViewById(R.id.subject);
                spinner1.setAdapter(adaptor1);
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                       Sub = spinner1.getSelectedItem().toString();
                       //Toast.makeText(getApplicationContext(),Sub,Toast.LENGTH_SHORT).show();
                       passvalues = Branch+ " " + Sub + " ";
                       //test = (TextView)findViewById(R.id.testwelcome);
                       //test.setText(passvalues);
                   }
                   @Override
                   public void onNothingSelected(AdapterView<?> adapterView) {

                   }
               });
                break;
            case 1:
                ArrayAdapter<String> adaptor2= new ArrayAdapter<String>(Welcome.this,android.R.layout.simple_spinner_dropdown_item,ECE);
                spinner1 = (Spinner)findViewById(R.id.subject);
                spinner1.setAdapter(adaptor2);
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                       // int position3 = spinner1.getSelectedItemPosition();
                        Sub = spinner1.getSelectedItem().toString();
                        //Toast.makeText(getApplicationContext(),Sub,Toast.LENGTH_SHORT).show();
                        passvalues = Branch+ " " + Sub + " ";
                       // test = (TextView)findViewById(R.id.testwelcome);
                        //test.setText(passvalues);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                break;
        }



         b1 = (Button)findViewById(R.id.next);
       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datetime = new Intent(Welcome.this,datatime2.class);
                datetime.putExtra("passvalues", passvalues);
                //Toast.makeText(getApplicationContext(),passvalues,Toast.LENGTH_SHORT).show();
                startActivity(datetime);
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
