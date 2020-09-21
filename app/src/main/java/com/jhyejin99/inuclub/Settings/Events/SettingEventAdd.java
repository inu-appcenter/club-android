package com.jhyejin99.inuclub.Settings.Events;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jhyejin99.inuclub.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SettingEventAdd extends Activity {
    ImageButton event_add_back;
    Button event_add_btn;
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;
    int mYear, mMonth, mDay, mHour, mMinute;
    int sYear, sMonth, sDay;

    TextView event_start_date;
    TextView event_start_time;
    TextView event_end_date;
    TextView event_end_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_event_add);

        event_add_back = (ImageButton)findViewById(R.id.event_add_back);
        event_start_date = (TextView) findViewById(R.id.event_start_date);
        event_start_time = (TextView)findViewById(R.id.event_start_time);
        event_end_date = (TextView)findViewById(R.id.event_end_date);
        event_end_time = (TextView)findViewById(R.id.event_end_time);

        final Calendar cal = new GregorianCalendar();

        event_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(SettingEventAdd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        sYear = year;
                        sMonth = month;
                        sDay = day;
                        String msg = String.format("%d년 %d월 %d일", year, month+1, day);
                        event_start_date.setText(msg);
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
                dialog.show();
            }
        });

        event_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(SettingEventAdd.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        String msg = String.format("%d시 %d분", hour, min);
                        event_start_time.setText(msg);
                    }
                }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
                dialog.show();
            }
        });

        event_end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(SettingEventAdd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        String msg = String.format("%d년 %d월 %d일", year, month+1, date);
                        event_end_date.setText(msg);
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
                dialog.show();
            }
        });

        event_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(SettingEventAdd.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        String msg = String.format("%d시 %d분", hour, min);
                        event_end_time.setText(msg);
                    }
                }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
                dialog.show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                }
            };

    TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mHour = hourOfDay;
                    mMinute = minute;
                }
            };
}
