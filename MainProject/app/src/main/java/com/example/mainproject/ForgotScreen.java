package com.example.mainproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotScreen extends AppCompatActivity {
    EditText userMail;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_screen);
        mAuth = FirebaseAuth.getInstance();
        userMail = findViewById(R.id.em);
    }

    public void forgot(View view) {
        final String mail = userMail.getText().toString();
        if(mail.isEmpty()){
            Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show();
        }

        mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                    mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotScreen.this, "Reset mail sent", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgotScreen.this,LoginScreen.class));


                            }
                            else{
                                String msg = task.getException().getMessage();
                                Toast.makeText(ForgotScreen.this, "Error "+msg, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            }
        });


    }

    public void goBack(View view) {
        Intent i = new Intent(this,LoginScreen.class);
        startActivity(i);
    }
}
