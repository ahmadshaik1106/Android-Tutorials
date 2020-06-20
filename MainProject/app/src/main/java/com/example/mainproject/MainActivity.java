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
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    EditText uname,email,pword1,pword2;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.em);
        uname = findViewById(R.id.name);
        pword1 = findViewById(R.id.pword1);
        pword2 = findViewById(R.id.pword2);
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(this,HomeScreen.class));
            finish();
        }
    }




    private void updateUI(FirebaseUser currentUser) {
    }

    public void gotoLogin(View view) {
        TextView tv = findViewById(R.id.regBtn);

        Intent i = new Intent(this,LoginScreen.class);
        startActivity(i);
    }

    public void register(View view) {
        String mail = email.getText().toString().trim();
        String password = pword1.getText().toString().trim();
        if(mail.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(MainActivity.this,HomeScreen.class));
                            Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}