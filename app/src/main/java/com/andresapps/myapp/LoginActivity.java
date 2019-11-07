package com.andresapps.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtEmail, edtPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtEmail.setError(null);
                edtPass.setError(null);

                if (edtEmail.getText() != null && edtEmail.getText().length() < 3) {
                    edtEmail.setError(getString(R.string.error_field));
                    edtEmail.requestFocus();
                } else if(edtPass.getText() != null && edtPass.getText().length() < 3) {
                    edtPass.setError(getString(R.string.error_field));
                    edtPass.requestFocus();
                } else {
                    findViewById(R.id.contentProgress).setVisibility(View.VISIBLE);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}