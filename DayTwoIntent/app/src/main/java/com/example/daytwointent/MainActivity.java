package com.example.daytwointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        link = findViewById(R.id.link);
    }

    public void send(View view) {
        String n = name.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("key",n);
        startActivity(i);
    }

    public void search(View view) {
        String l = link.getText().toString().trim();
        Uri uri;
        uri = Uri.parse("https://"+l);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        Toast.makeText(this,"opening "+uri,Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}
