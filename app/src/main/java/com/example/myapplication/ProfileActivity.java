package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends Activity {

    private EditText nameInput;
    private EditText emailInput;
    private EditText registrationInput;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        registrationInput = findViewById(R.id.registrationInput);

        Button saveButton = findViewById(R.id.editButton);
        Button logoutButton = findViewById(R.id.logoutButton);

        preferences = getSharedPreferences(
                "StudentProfile",
                MODE_PRIVATE
        );

        nameInput.setText(preferences.getString("name", ""));
        emailInput.setText(preferences.getString("email", ""));
        registrationInput.setText(
                preferences.getString("registration", "")
        );

        saveButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String registration =
                    registrationInput.getText().toString().trim();

            if (name.isEmpty()) {
                nameInput.setError("Enter your name");
                nameInput.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email");
                emailInput.requestFocus();
            } else if (registration.isEmpty()) {
                registrationInput.setError(
                        "Enter your registration number"
                );
                registrationInput.requestFocus();
            } else {
                preferences.edit()
                        .putString("name", name)
                        .putString("email", email)
                        .putString("registration", registration)
                        .apply();

                Toast.makeText(
                        ProfileActivity.this,
                        "Profile saved successfully",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ProfileActivity.this,
                    LoginActivity.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);
        });
    }
}