package com.example.root.Attendo;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.Attendo.R;

public class TeacherInput extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText teachername, teacherdepartment;
    private TextInputLayout inputlayoutName, inputlayoutdepartment;
    private Button next;
    String teacherdetails, tdname,tname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_input);

        //toolbar = (Toolbar)findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        inputlayoutName = (TextInputLayout)findViewById(R.id.input_layout_name);
        inputlayoutdepartment =(TextInputLayout)findViewById(R.id.input_layout_department);
        teachername = (EditText)findViewById(R.id.input_name);
        teacherdepartment = (EditText)findViewById(R.id.input_department);
        next = (Button)findViewById(R.id.teacherinputnext);

        teachername.addTextChangedListener(new MyTextWatcher(teachername));
        teacherdepartment.addTextChangedListener(new MyTextWatcher(teacherdepartment));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitform();
            }
        });
    }

    private void submitform(){
        if(!validateName()){
            return ;
        }
        if(!validDepartment()){
            return;
        }

        teacherdetails = tname + " (" + tdname + ") ";
       // Toast.makeText(getApplicationContext(), teacherdetails, Toast.LENGTH_SHORT).show();
        Intent teacher = new Intent(TeacherInput.this, MainActivity.class);
        teacher.putExtra("teacherdetails", teacherdetails);
        startActivity(teacher);

    }

    private boolean validDepartment() {
        tdname = teacherdepartment.getText().toString().trim();
        if (teacherdepartment.getText().toString().trim().isEmpty()) {
            inputlayoutdepartment.setError("Error");
            requestFocus(teacherdepartment);
            return false;
        } else {
            inputlayoutdepartment.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateName() {
        tname = teachername.getText().toString().trim();
        if (teachername.getText().toString().trim().isEmpty()) {
            inputlayoutName.setError("Error");
            requestFocus(teachername);
            return false;
        } else {
            inputlayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_department:
                    validDepartment();
                    break;

            }
        }
    }
}

