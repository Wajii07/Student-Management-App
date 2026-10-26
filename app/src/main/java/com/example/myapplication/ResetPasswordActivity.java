package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPasswordActivity extends Activity {

    private EditText newPasswordInput;
    private EditText confirmPasswordInput;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        email = getIntent().getStringExtra("email");

        newPasswordInput = findViewById(R.id.newPasswordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);

        Button saveButton = findViewById(R.id.saveButton);
        TextView backToLogin = findViewById(R.id.backToLogin);

        saveButton.setOnClickListener(v -> {
            String password = newPasswordInput.getText().toString();
            String confirmPassword =
                    confirmPasswordInput.getText().toString();

            if (TextUtils.isEmpty(password)) {
                newPasswordInput.setError("Enter a new password");
                newPasswordInput.requestFocus();
            } else if (password.length() < 6) {
                newPasswordInput.setError(
                        "Password must contain at least 6 characters"
                );
                newPasswordInput.requestFocus();
            } else if (!password.equals(confirmPassword)) {
                confirmPasswordInput.setError(
                        "Passwords do not match"
                );
                confirmPasswordInput.requestFocus();
            } else {
                Toast.makeText(
                        ResetPasswordActivity.this,
                        "Password reset demo completed for " + email,
                        Toast.LENGTH_LONG
                ).show();

                Intent intent = new Intent(
                        ResetPasswordActivity.this,
                        LoginActivity.class
                );

                intent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
                                | Intent.FLAG_ACTIVITY_SINGLE_TOP
                );

                startActivity(intent);
                finish();
            }
        });

        backToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ResetPasswordActivity.this,
                    LoginActivity.class
            );
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}