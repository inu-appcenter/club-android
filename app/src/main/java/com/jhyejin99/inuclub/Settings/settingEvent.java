package com.jhyejin99.inuclub.Settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.jhyejin99.inuclub.R;

public class settingEvent extends Activity {

    RecyclerView rc_event_list;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_event);

        rc_event_list = (RecyclerView)findViewById(R.id.rc_event_list);
        rc_event_list.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rc_event_list.setLayoutManager(layoutManager);

        ImageButton event_add_btn1 = (ImageButton) findViewById(R.id.event_add_btn1);
        ImageButton event_back = (ImageButton)findViewById(R.id.event_edit_back);

        event_add_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settingEvent.this, settingEventAdd.class);
                startActivity(intent);
                finish();
            }
        });

        //event_back.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
                //finish();
        //    }
       // });

    }
}
