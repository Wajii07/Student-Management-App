package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private EditText nameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);

        Button registerButton = findViewById(R.id.registerButton);
        TextView loginLink = findViewById(R.id.loginLink);

        registerButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String confirmPassword =
                    confirmPasswordInput.getText().toString();

            if (TextUtils.isEmpty(name)) {
                nameInput.setError("Enter your full name");
                nameInput.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email");
                emailInput.requestFocus();
            } else if (password.length() < 6) {
                passwordInput.setError(
                        "Password must contain at least 6 characters"
                );
                passwordInput.requestFocus();
            } else if (!password.equals(confirmPassword)) {
                confirmPasswordInput.setError(
                        "Passwords do not match"
                );
                confirmPasswordInput.requestFocus();
            } else {
                Toast.makeText(
                        RegisterActivity.this,
                        "Registration details validated!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        loginLink.setOnClickListener(v -> {
            Intent intent = new Intent(
                    RegisterActivity.this,
                    LoginActivity.class
            );
            startActivity(intent);
            finish();
        });
    }
}