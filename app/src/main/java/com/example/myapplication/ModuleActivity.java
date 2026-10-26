package com.example.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ModuleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        TextView title = findViewById(R.id.moduleTitle);
        TextView description = findViewById(R.id.moduleDescription);

        String module = getIntent().getStringExtra("module");

        if (module == null) {
            module = "Student Module";
        }

        title.setText(module);

        switch (module) {
            case "Attendance":
                description.setText(
                        "View your attendance records and attendance percentage."
                );
                break;

            case "Courses":
                description.setText(
                        "View your enrolled courses and course information."
                );
                break;

            case "Marks":
                description.setText(
                        "View your quiz, assignment and examination marks."
                );
                break;

            case "Timetable":
                description.setText(
                        "View your weekly class timetable and class timings."
                );
                break;

            case "Assignments":
                description.setText(
                        "View your assignments, due dates and submission status."
                );
                break;

            default:
                description.setText(
                        "Student academic information will appear here."
                );
                break;
        }
    }
}