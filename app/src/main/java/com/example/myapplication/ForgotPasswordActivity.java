package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordActivity extends Activity {

    private EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.emailInput);

        Button resetButton = findViewById(R.id.resetButton);
        TextView backToLogin = findViewById(R.id.backToLogin);

        resetButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                emailInput.setError("Email is required");
                emailInput.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email address");
                emailInput.requestFocus();
            } else {
                Intent intent = new Intent(
                        ForgotPasswordActivity.this,
                        ResetPasswordActivity.class
                );

                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        backToLogin.setOnClickListener(v -> finish());
    }
}
