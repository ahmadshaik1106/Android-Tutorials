package com.example.daytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    public void toast(View view) {
        Toast.makeText(this,"It is Toast "+i,Toast.LENGTH_SHORT).show();
    }

    public void count(View view) {

    }

    public void add(View view) {

        if(i>=99){
            Toast.makeText(this,"You cannot add more than "+i,Toast.LENGTH_SHORT).show();
        }else {
            i++;
            tv.setText("" + i);
        }
    }

    public void subtract(View view) {
        if(i<=0){
            Toast.makeText(this,"You can not subtract less than "+i,Toast.LENGTH_SHORT).show();
        }else {
            i--;
            tv.setText("" + i);
        }
    }
}

