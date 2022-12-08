package com.example.healthinsurance.ui.auth;

import static android.util.Patterns.EMAIL_ADDRESS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthinsurance.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.PasswordAuthentication;
import java.util.regex.Pattern;

public class RegstierActivity extends AppCompatActivity {
    private EditText editTextName, editTextemil, editTextphone, editTextpassword, editTextconfirmpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regstier);

        mAuth = FirebaseAuth.getInstance();

        editTextName = findViewById(R.id.reg_name);
        editTextemil = findViewById(R.id.reg_email);
        editTextphone = findViewById(R.id.reg_phone);
        editTextpassword = findViewById(R.id.reg_password);
        editTextconfirmpassword = findViewById(R.id.reg_confirm_password);
        findViewById(R.id.but_signup).setOnClickListener(view -> {
            RegisterCode();
        });


    }

    private void RegisterCode() {
        String name = editTextName.getText().toString().trim();
        String emil = editTextemil.getText().toString().trim();
        String phone = editTextphone.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String confirm_password = editTextconfirmpassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(emil, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(RegstierActivity.this,LoginActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegstierActivity.this, "", Toast.LENGTH_SHORT).show();   
                        }
                    }
                });
        
        

           /* if (name.isEmpty()) {
                editTextName.requestFocus();
                Toast.makeText(RegstierActivity.this, "name is required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (emil.isEmpty()) {
                editTextemil.requestFocus();
                Toast.makeText(RegstierActivity.this, "email is required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (Patterns.EMAIL_ADDRESS.matcher(emil).matches()) {
                editTextemil.requestFocus();
                Toast.makeText(RegstierActivity.this, "email is required", Toast.LENGTH_SHORT).show();
                return;
            }


            if (phone.isEmpty()) {
                editTextphone.requestFocus();
                Toast.makeText(RegstierActivity.this, "phone is required", Toast.LENGTH_SHORT).show();
                return;
            }


            if (phone.length() < 11) {
                editTextphone.requestFocus();
                Toast.makeText(RegstierActivity.this, "it should be degits", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                editTextpassword.requestFocus();
                Toast.makeText(RegstierActivity.this, "password is required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                editTextpassword.requestFocus();
                Toast.makeText(RegstierActivity.this, "password should be degits", Toast.LENGTH_SHORT).show();
                return;
            }

            if (confirm_password.isEmpty()) {
                editTextconfirmpassword.requestFocus();
                Toast.makeText(RegstierActivity.this, "confirm is required", Toast.LENGTH_SHORT).show();
                return;
            } */



    }
}