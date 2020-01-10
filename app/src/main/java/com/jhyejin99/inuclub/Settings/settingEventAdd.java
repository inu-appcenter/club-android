package com.jhyejin99.inuclub.Settings;

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

public class settingEventAdd extends Activity {
    ImageButton event_add_back;
    Button event_add_btn;
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;
    int start_date_y,start_date_m, start_date_d, start_time_h, start_time_m;
    int end_date_y, end_date_m, end_date_d, end_time_h, end_time_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_event_add);

        event_add_back = (ImageButton)findViewById(R.id.event_add_back);
        TextView event_start_date = (TextView) findViewById(R.id.event_start_date);
        TextView event_start_time = (TextView)findViewById(R.id.event_start_time);
        TextView event_end_date = (TextView)findViewById(R.id.event_end_date);
        TextView event_end_time = (TextView)findViewById(R.id.event_end_time);

        event_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DATE);
            }
        });

        event_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_TIME);
            }
        });

        event_end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DATE);
            }
        });

        event_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_TIME);
            }
        });

    }

    public Dialog onCreateDialog(int id){
        switch(id){
            case DIALOG_DATE :
                DatePickerDialog datePickerDialog = new DatePickerDialog(settingEventAdd.this,
                        new DatePickerDialog.OnDateSetListener(){
                            public void onDateSet(DatePicker view, int year, int month, int day){
                                Toast.makeText(getApplicationContext(),year+"년 "+(month+1)+"월 "+day +"일을 선택했습니다",Toast.LENGTH_LONG).show();
                            }
                        },2019,9,17);
                return datePickerDialog;

            case DIALOG_TIME :
                TimePickerDialog timePickerDialog = new TimePickerDialog(settingEventAdd.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                Toast.makeText(getApplicationContext(),hour+"시 "+ minute +"분을 선택했습니다",Toast.LENGTH_LONG).show();
                            }
                        }, 11,30,false);
                return timePickerDialog;
        }
        return super.onCreateDialog(id);
    }
}
