package com.example.root.Attendo.Data;

import android.content.Intent;
import android.provider.BaseColumns;

/**
 * Created by root on 7/27/17.
 */

public class StudentContract {

    public static abstract class StudentEntry implements BaseColumns{

        public static final String TABLE_NAME = "students";
        public static final String _ID = BaseColumns._ID;
        public static final String ROLL_NUMBER = "rollnumber";
        public static final String STUDENT_NAME = "name";
        public static final String STUDENT_BRANCH = "branch";
        public static final String STUDENT_SEMESTER = "semester";
        public static final String STUDENT_ATTENDANCE = "Attendance";

    }
}
