package com.example.mainproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    EditText m,p;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        m = findViewById(R.id.em);
        p = findViewById(R.id.p);
        mAuth = FirebaseAuth.getInstance();
    }

    public void gotoRegister(View view) {
        TextView tv = findViewById(R.id.regLink);

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void login(View view) {
        String mail = m.getText().toString().trim();
        String pass = p.getText().toString().trim();
        if(mail.isEmpty()||pass.isEmpty()){
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginScreen.this, "Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginScreen.this,HomeScreen.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void gotoForgot(View view) {
        Intent i = new Intent(this,ForgotScreen.class);
        startActivity(i);
    }
}
