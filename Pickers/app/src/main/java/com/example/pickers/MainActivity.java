package com.example.pickers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int currentYear, currentMonth, currentDay;
    int currentHour, currentMinute;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);

    }

    public void getPopUp(View view) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("Alert");
        b.setMessage("Do you want to exit");
//        b.setIcon(R.drawable.alert);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.show();

    }

    public void getDatePicker(View view) {
        Calendar c = Calendar.getInstance();

        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String m = String.format("%02d", (month + 1));
                String d = String.format("%02d", dayOfMonth);
                tv.setText(d + "-" + m + "-" + year);
                System.out.println("" + d + "-" + m + "-" + year);
            }
        }, currentYear, currentMonth, currentDay);
        dp.show();
    }


    public void getTimePicker(View view) {
        Calendar c = Calendar.getInstance();
        currentHour  = c.get(Calendar.HOUR_OF_DAY);
        currentMinute = c.get(Calendar.MINUTE);
        TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String h = String.format("%02d",hourOfDay);
                String m = String.format("%02d",minute);
                tv2.setText(h+":"+m);
            }
        },currentHour,currentMinute,false);
        tp.show();
    }
}

