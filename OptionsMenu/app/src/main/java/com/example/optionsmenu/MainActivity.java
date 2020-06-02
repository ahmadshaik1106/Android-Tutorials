package com.example.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.i1:
                Intent intent1 = new Intent(this,SettingsActivity.class);
                startActivity(intent1);
                Toast.makeText(this,"You slected "+item.getTitle(),Toast.LENGTH_SHORT).show();break;
            case R.id.i2:
                Uri uri = Uri.parse("https://web.whatsapp.com/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent2);
                Toast.makeText(this,"You slected "+item.getTitle(),Toast.LENGTH_SHORT).show();break;
            case R.id.i3:
                Intent intent3 = new Intent(this,SecondActivity.class);
                startActivity(intent3);
                Toast.makeText(this,"You slected "+item.getTitle(),Toast.LENGTH_SHORT).show();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
