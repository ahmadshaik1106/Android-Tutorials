package com.example.daytwointent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra("key");
        Toast.makeText(this,"Welcome "+name,Toast.LENGTH_SHORT).show();
        tv = findViewById(R.id.yourName);
        tv.setText("Hi "+name);
    }
}
