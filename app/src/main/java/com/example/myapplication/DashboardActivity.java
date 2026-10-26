package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView attendance = findViewById(R.id.attendanceCard);
        TextView courses = findViewById(R.id.coursesCard);
        TextView marks = findViewById(R.id.marksCard);
        TextView timetable = findViewById(R.id.timetableCard);
        TextView assignments = findViewById(R.id.assignmentsCard);
        TextView profile = findViewById(R.id.profileCard);

        View.OnClickListener moduleListener = v -> {

            if (v.getId() == R.id.profileCard) {
                startActivity(new Intent(
                        DashboardActivity.this,
                        ProfileActivity.class
                ));
            } else {
                String moduleName = ((TextView) v)
                        .getText()
                        .toString();

                String[] parts = moduleName.split("\n");
                moduleName = parts[parts.length - 1];

                Intent intent = new Intent(
                        DashboardActivity.this,
                        ModuleActivity.class
                );

                intent.putExtra("module", moduleName);
                startActivity(intent);
            }
        };

        attendance.setOnClickListener(moduleListener);
        courses.setOnClickListener(moduleListener);
        marks.setOnClickListener(moduleListener);
        timetable.setOnClickListener(moduleListener);
        assignments.setOnClickListener(moduleListener);
        profile.setOnClickListener(moduleListener);
    }
}